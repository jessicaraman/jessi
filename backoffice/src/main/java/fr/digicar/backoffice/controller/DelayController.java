package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.DelayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/delays")
public class DelayController {

    @Autowired
    private DelayService delayService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showDelayNumber() {
        ModelAndView modelAndView = new ModelAndView("delay-analysis");
        modelAndView.addObject("delayNumber", delayService.getDelayNumber());
        modelAndView.addObject("delayDistribution", delayService.getDelayDistribution());
        return modelAndView;
    }

}
