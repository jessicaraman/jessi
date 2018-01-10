package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.TarifService;
import fr.digicar.model.Tarif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TarifController {

    @Autowired
    private TarifService tarifService;

    //redirecting to list of pricing
    @RequestMapping(value = "/pricing", method = RequestMethod.GET)
    public ModelAndView addPricingPage() {
        ModelAndView modelAndView = new ModelAndView("add-price-form");
        modelAndView.addObject("tarif", new Tarif());
        List listOfPricings = tarifService.getTarifs();
        modelAndView.addObject("listOfPricings", listOfPricings);
        return modelAndView;
    }
    //pour l'ajout

    @RequestMapping(value = "/pricing/addPricing", method = RequestMethod.POST)
    public ModelAndView addingPricing(@ModelAttribute Tarif tarif) {
        tarifService.addTarif(tarif);
        ModelAndView modelAndView = new ModelAndView("add-price-form");
        List listOfPricings = tarifService.getTarifs();
        modelAndView.addObject("listOfPricings", listOfPricings);
        return modelAndView;
    }
}