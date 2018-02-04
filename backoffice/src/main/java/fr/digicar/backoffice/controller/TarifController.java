package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.TarifService;
import fr.digicar.model.Tarif;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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


    @RequestMapping(value = "/pricing/addPricing", method = RequestMethod.POST)
    public ModelAndView addingPricing(@ModelAttribute Tarif tarif) {
        tarifService.addTarif(tarif);
        ModelAndView modelAndView = new ModelAndView("add-price-form");
        modelAndView.addObject("tarif", new Tarif());
        List listOfPricings = tarifService.getTarifs();
        modelAndView.addObject("listOfPricings", listOfPricings);
        return modelAndView;
    }


    @RequestMapping(value = "/pricing/search", method = RequestMethod.GET)
    public ModelAndView searchView() {
        ModelAndView modelAndView = new ModelAndView("search-price-form");
        /*  List<Tarif> foundPrices=tarifService.getTarifs();
        modelAndView.addObject("foundPrices", foundPrices);*/
        return modelAndView;
    }


    @RequestMapping(value = "/pricing/searchs", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("libelle") String libelle) {
        ModelAndView modelAndView = new ModelAndView("search-price-form");
        List<Tarif> foundPrices=tarifService.searchTarifs(libelle,1,2,3,4,5,6);
        modelAndView.addObject("foundPrices", foundPrices);
        return modelAndView;
    }



}