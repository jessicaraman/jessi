package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.TarifService;
import fr.digicar.model.Pricing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PricingController {

    @Autowired
    private TarifService tarifService;

    //redirecting to list of pricing
    @RequestMapping(value = "/pricing", method = RequestMethod.GET)
    public ModelAndView addPricingPage() {
        ModelAndView modelAndView = new ModelAndView("add-price-form");
        modelAndView.addObject("tarif", new Pricing());
        List listOfPricings = tarifService.getTarifs();
        modelAndView.addObject("listOfPricings", listOfPricings);
        return modelAndView;
    }


    @RequestMapping(value = "/pricing/addPricing", method = RequestMethod.POST)
    public ModelAndView addingPricing(@ModelAttribute Pricing pricing) {
        tarifService.addTarif(pricing);
        ModelAndView modelAndView = new ModelAndView("add-price-form");
        modelAndView.addObject("tarif", new Pricing());
        List listOfPricings = tarifService.getTarifs();
        modelAndView.addObject("listOfPricings", listOfPricings);
        return modelAndView;
    }


    @RequestMapping(value = "/pricing/search", method = RequestMethod.GET)
    public ModelAndView searchView() {
        ModelAndView modelAndView = new ModelAndView("search-price-form");
        List<Pricing> foundPrices = tarifService.getTarifs();
        modelAndView.addObject("foundPrices", foundPrices);
        return modelAndView;
    }


    @RequestMapping(value = "/pricing/searchs", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("label") String label,
                               @RequestParam("minKmPrice") String minKmPrice,
                               @RequestParam("maxKmPrice") String maxKmPrice,
                               @RequestParam("minHourlyPrice") String minHourlyPrice,
                               @RequestParam("maxHourlyPrice") String maxHourlyPrice,
                               @RequestParam("minMonthlyFees") String minMonthlyFees,
                               @RequestParam("maxMonthlyFees") String maxMonthlyFees) {
        ModelAndView modelAndView = new ModelAndView("search-price-form");
        if (label.isEmpty()) {
            label = "none";
        }
        if (minKmPrice.isEmpty()) {
            minKmPrice = "-1";
        }
        if (maxKmPrice.isEmpty()) {
            maxKmPrice = "12345";
        }
        if (minHourlyPrice.isEmpty()) {
            minHourlyPrice = "-1";
        }
        if (maxHourlyPrice.isEmpty()) {
            maxHourlyPrice = "12345";
        }
        if (minMonthlyFees.isEmpty()) {
            minMonthlyFees = "-1";
        }
        if (maxMonthlyFees.isEmpty()) {
            maxMonthlyFees = "12345";
        }
        List<Pricing> foundPrices = tarifService.searchTarifs(label,
                Float.parseFloat(minKmPrice),
                Float.parseFloat(maxKmPrice),
                Float.parseFloat(minHourlyPrice),
                Float.parseFloat(maxHourlyPrice),
                Integer.parseInt(minMonthlyFees),
                Integer.parseInt(maxMonthlyFees));
        modelAndView.addObject("foundPrices", foundPrices);
        return modelAndView;
    }

}
