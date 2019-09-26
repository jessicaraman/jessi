package fr.digicar.webportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LocationController {
    @RequestMapping(value = "/lieu")
    public ModelAndView mainPage() {
        return new ModelAndView("lieu");
    }
}
