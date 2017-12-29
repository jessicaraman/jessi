package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.TarifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/pricing")
public class TarifController {

    @Autowired
    private TarifService tarifService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView addPrice() {
        return new ModelAndView("add-price-form");
    }

}
