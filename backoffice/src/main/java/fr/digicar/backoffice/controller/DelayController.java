package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.DelayService;
import fr.digicar.backoffice.utils.DelayDistribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
        modelAndView.addObject("delayNumber", delayService.getDelayNumber(getPreviousYearDate(today), today));
        DelayDistribution delayDistribution = delayService.getDelayDistribution(getPreviousYearDate(today), today);
        modelAndView.addObject("delayDistribution", delayDistribution.getValues());
        modelAndView.addObject("delayDistributionLabels", delayDistribution.getLabels());
        return modelAndView;
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
