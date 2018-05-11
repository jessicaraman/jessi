package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.DelayService;
import fr.digicar.backoffice.utils.DelayDistribution;
import fr.digicar.backoffice.utils.SearchPeriod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Slf4j
@Controller
@RequestMapping("/delays")
public class DelayController {

    @Autowired
    private DelayService delayService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showDelayNumber() {
        Date today = new Date();
        ModelAndView modelAndView = new ModelAndView("delay-analysis");
        modelAndView.addObject("resultDate", getResultDateString(getPreviousYearDate(today), today));
        modelAndView.addObject("delayNumber", delayService.getDelayNumber(getPreviousYearDate(today), today, false));
        DelayDistribution delayDistribution = delayService.getDelayDistribution(getPreviousYearDate(today), today, false);
        modelAndView.addObject("delayDistribution", delayDistribution.getValues());
        modelAndView.addObject("delayDistributionLabels", delayDistribution.getLabels());
        modelAndView.addObject("searchPeriod", new SearchPeriod());
        modelAndView.addObject("filtered", false);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String filterByDate(@ModelAttribute SearchPeriod searchPeriod, ModelMap model) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            searchPeriod.setStartDate(format.parse(searchPeriod.getStartDateString()));
            searchPeriod.setEndDate(format.parse(searchPeriod.getEndDateString()));
        } catch (ParseException e) {
            log.error("Error when parsing dates to filter delays.", e);
            searchPeriod.setStartDate(getPreviousYearDate(new Date()));
            searchPeriod.setEndDate(new Date());
        }
        model.addAttribute("resultDate", getResultDateString(searchPeriod.getStartDate(), searchPeriod.getEndDate()));
        model.addAttribute("delayNumber", delayService.getDelayNumber(searchPeriod.getStartDate(), searchPeriod.getEndDate(), false));
        DelayDistribution delayDistribution = delayService.getDelayDistribution(searchPeriod.getStartDate(), searchPeriod.getEndDate(), false);
        model.addAttribute("delayDistribution", delayDistribution.getValues());
        model.addAttribute("delayDistributionLabels", delayDistribution.getLabels());
        model.addAttribute("searchPeriod", searchPeriod);
        return "delay-analysis";
    }

    @RequestMapping(value = "/filtered", method = RequestMethod.POST)
    public String excludeAtypicalDelays(ModelMap model) {
        Date today = new Date();

        DelayDistribution standardDelayDistribution = delayService.getDelayDistribution(getPreviousYearDate(today), today, false);
        model.addAttribute("resultDate", getResultDateString(getPreviousYearDate(today), today));
        model.addAttribute("delayNumber", delayService.getDelayNumber(getPreviousYearDate(today), today, false));
        model.addAttribute("delayDistribution", standardDelayDistribution.getValues());
        model.addAttribute("delayDistributionLabels", standardDelayDistribution.getLabels());

        DelayDistribution cleanDelayDistribution = delayService.getDelayDistribution(getPreviousYearDate(today), today, true);
        model.addAttribute("cleanResultDate", getResultDateString(getPreviousYearDate(today), today));
        model.addAttribute("cleanDelayNumber", delayService.getDelayNumber(getPreviousYearDate(today), today, true));
        model.addAttribute("cleanDelayDistribution", cleanDelayDistribution.getValues());
        model.addAttribute("cleanDelayDistributionLabels", cleanDelayDistribution.getLabels());

        model.addAttribute("searchPeriod", new SearchPeriod());
        model.addAttribute("filtered", true);
        return "delay-analysis";
    }

    private Date getPreviousYearDate(Date date) {
        Calendar previousYearDate = Calendar.getInstance();
        previousYearDate.setTime(date);
        previousYearDate.add(Calendar.YEAR, -1);
        return previousYearDate.getTime();
    }

    private String getResultDateString(Date dateStart, Date dateEnd) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM yyyy", Locale.FRENCH);
        String dateStartString = dateFormat.format(dateStart);
        String dateEndString = dateFormat.format(dateEnd);
        return dateStartString.substring(0, 1).toUpperCase()
                + dateStartString.substring(1)
                + " - "
                + dateEndString.substring(0, 1).toUpperCase()
                + dateEndString.substring(1);
    }

}
