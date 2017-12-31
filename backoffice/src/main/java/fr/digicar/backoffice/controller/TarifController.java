package fr.digicar.backoffice.controller;

import java.util.List;

import fr.digicar.model.ParkingSpot;
import fr.digicar.model.Tarif;
import fr.digicar.backoffice.service.TarifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TarifController {

    private TarifService tarifService;


    @RequestMapping(value = "/pricing", method = RequestMethod.GET)
    public ModelAndView addPricingPage() {
        ModelAndView modelAndView = new ModelAndView("add-price-form");
        modelAndView.addObject("tarif", new Tarif());
        return modelAndView;
    }
  /*  @RequestMapping(value = "/pricing/addPricing", method = RequestMethod.POST)
    public String addPricing(@ModelAttribute("tarif")Tarif tarif, ModelMap model) {
        model.addAttribute("name", tarif.getLibelle());
        model.addAttribute("age", tarif.getPrix_heure());
        model.addAttribute("id", tarif.getPrix_km());
        return "result";
    }*/
  @RequestMapping(value = "/pricing/addPricing", method = RequestMethod.GET)
      public void addingPricing(@ModelAttribute("tarif") Tarif tarif) {
          ModelAndView modelAndView = new ModelAndView("home");
          tarifService.addTarif(tarif);

      }


}