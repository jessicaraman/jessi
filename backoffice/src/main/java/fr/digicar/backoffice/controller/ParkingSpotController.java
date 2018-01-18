package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.ParkingSpotService;
import fr.digicar.model.ParkingSpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping(value = "/parking")
public class ParkingSpotController {

    @Autowired
    private ParkingSpotService parkingSpotService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addCreateParkingSpotPage() {
        ModelAndView modelAndView = new ModelAndView("add-parking-spot-form");
        modelAndView.addObject("parking", new ParkingSpot());
        return modelAndView;
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView addSearchParkingSpotPage() {
        ModelAndView modelAndView = new ModelAndView("search-parking-spot-form");
        modelAndView.addObject("searchparking", new ParkingSpot());
        return modelAndView;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView AddMenuParkingSpotPage() {
        ModelAndView modelAndView = new ModelAndView("menu-parking-spot-form");
        modelAndView.addObject("parking", new ParkingSpot());
        List<ParkingSpot> parkingSpots = parkingSpotService.getParkingSpots();
        modelAndView.addObject("parkingSpot", parkingSpots);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addingParkingSpot(@ModelAttribute ParkingSpot parkingSpot) {

        ModelAndView modelAndView = new ModelAndView("menu-parking-spot-form");
        modelAndView.addObject("parking", new ParkingSpot());
        parkingSpotService.addParkingSpot(parkingSpot);
        String message = parkingSpot.getNbSpot() + " ont été ajoutées.";
        List<ParkingSpot> parkingSpots = parkingSpotService.getParkingSpots();
        modelAndView.addObject("parkingSpot", parkingSpots);
        modelAndView.addObject("message", message);
        return modelAndView;
    }

   /* @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
    public ModelAndView searchingParkingSpot(@PathVariable int id) {

        ModelAndView modelAndView = new ModelAndView("search-parking-spot-form");
        ParkingSpot resultParkingSpot = parkingSpotService.getParkingSpot(id);
        modelAndView.addObject("parkingSpot", resultParkingSpot);
        return modelAndView;
    }*/

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView searchingParkingSpot(@ModelAttribute ParkingSpot parkingSpot) {

        ModelAndView modelAndView = new ModelAndView("home");

        ParkingSpot resultParkingSpot = parkingSpotService.getParkingSpot(parkingSpot.getId());
        modelAndView.addObject("parkingSpot", resultParkingSpot);
        return modelAndView;
    }


/*
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editParkingSpotPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-parking-spot-form");
        ParkingSpot parkingSpot = parkingSpotService.getParkingSpot(id);
        modelAndView.addObject("parkingSpot", parkingSpot);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edditingParkingSpot(@ModelAttribute ParkingSpot parkingSpot, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("home");

        parkingSpotService.updateParkingSpot(parkingSpot);

        String message = parkingSpot.getNbSpot() + " a ete modifee.";

        List<ParkingSpot> parkingSpots = parkingSpotService.getParkingSpots();
        modelAndView.addObject("parkingSpot", parkingSpot);
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteParkingSpot(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("home");
        parkingSpotService.deleteParkingSpot(id);
        String message = "une place supprime.";
        List<ParkingSpot> parkingSpots = parkingSpotService.getParkingSpots();
        modelAndView.addObject("parkingSpot", parkingSpots);
        modelAndView.addObject("message", message);
        return modelAndView;
    }*/

}
