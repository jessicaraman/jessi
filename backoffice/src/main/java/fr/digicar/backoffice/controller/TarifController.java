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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TarifController {

    private TarifService tarifService;
    private Tarif t;

    @RequestMapping(value = "/pricing", method = RequestMethod.GET)
    public ModelAndView addPricingPage() {
        ModelAndView modelAndView = new ModelAndView("add-price-form");
        modelAndView.addObject("tarif", new Tarif());
        return modelAndView;
    }



    //For add and update person both
    /*@RequestMapping(value= "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p){

        if(p.getId() == 0){
            //new person, add it
            this.personService.addPerson(p);
        }else{
            //existing person, call update
            this.personService.updatePerson(p);
        }

        return "redirect:/persons";

    }
   @RequestMapping(value = "/pricing/addPricing", method = RequestMethod.POST)
    public String addPricing(@RequestParam("libelle") String libelle,@RequestParam("prix_heure") String prix_heure,
                             @RequestParam("prix_km") String prix_km,@RequestParam("frais_mensuels") String fraismensuels) {
   t.setPrix_km(prix_km);
        return "home";
    }
  /*@RequestMapping(value = "/pricing/addPricing", method = RequestMethod.GET)
      public void addingPricing(@ModelAttribute("tarif") Tarif tarif) {
          ModelAndView modelAndView = new ModelAndView("home");
          tarifService.addTarif(tarif);

      }
*/

}