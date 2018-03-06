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
    public ModelAndView search(@RequestParam("libelle") String libelle,@RequestParam("prix_km_min")String prix_km_min,
                               @RequestParam("prix_km_max")String prix_km_max,@RequestParam("prix_heure_min")String prix_heure_min,
                               @RequestParam("prix_heure_max")String prix_heure_max,@RequestParam("frais_mensuels_min")String frais_mensuels_min,
                               @RequestParam("frais_mensuels_max")String frais_mensuels_max){
        ModelAndView modelAndView = new ModelAndView("search-price-form");
        if(libelle.isEmpty()){libelle="none";}
        if (prix_km_min.isEmpty()){prix_km_min="-1";}
        if (prix_km_max.isEmpty()){prix_km_max="12345";}
        if (prix_heure_min.isEmpty()){prix_heure_min="-1";}
        if (prix_heure_max.isEmpty()){prix_heure_max="12345";}
        if (frais_mensuels_min.isEmpty()){frais_mensuels_min="-1";}
        if (frais_mensuels_max.isEmpty()){frais_mensuels_max="12345";}
        List<Tarif> foundPrices=tarifService.searchTarifs(libelle, Float.parseFloat(prix_km_min), Float.parseFloat(prix_km_max),
                Float.parseFloat(prix_heure_min),Float.parseFloat(prix_heure_max),Integer.parseInt(frais_mensuels_min),
                Integer.parseInt(frais_mensuels_max));
        modelAndView.addObject("foundPrices", foundPrices);
        return modelAndView;
    }



}