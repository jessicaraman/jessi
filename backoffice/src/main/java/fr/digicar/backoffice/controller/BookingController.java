package fr.digicar.backoffice.controller;


import fr.digicar.backoffice.service.*;
import fr.digicar.model.Car;
import fr.digicar.model.CarAvailability;
import fr.digicar.model.ParkingSpot;
import fr.digicar.odt.FilterBookingOdt;
import fr.digicar.odt.ReservationOdt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Slf4j
@Controller
@RequestMapping("/reservation")
public class BookingController {

    @Autowired
    private CarAvailabilityService carAvailabilityService;

    @Autowired
    private CarTypeService carTypeService;

    @Autowired
    private CarService carService;

    @Autowired
    private ParkingSpotService parkingSpotService;

    @Autowired
    private ParkingService parkingService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView getViewFoCarResevation() {


        ModelAndView modelAndView = new ModelAndView("reservation");
        Set setOfTown = new TreeSet();
        List listOfCarType = new ArrayList();

        try {
            setOfTown = parkingSpotService.getListOfLocation();
            listOfCarType = carTypeService.getAllCarType();
        } catch (Exception e) {
            log.error("Could not get the list of parking spot. ", e);
        }

        modelAndView.addObject("setOfTown", setOfTown);
        modelAndView.addObject("listOfCarType", listOfCarType);
        modelAndView.addObject("filters", new FilterBookingOdt());
        modelAndView.addObject("cars", new ArrayList<>());

        return modelAndView;
    }

    //allcaravailabilities
    @RequestMapping(value = "/carAvailable", method = RequestMethod.POST)
    public ModelAndView findCarAvailabilityByCriteria(@ModelAttribute("filters") final FilterBookingOdt filters) {


        List<ReservationOdt> potentialBooking = new ArrayList<>();
        Set setOfTown = new TreeSet();
        List listOfCarType = new ArrayList();

        try {
            potentialBooking = carAvailabilityService.getCarAvailabilityBy(filters);

            setOfTown = parkingSpotService.getListOfLocation();
            listOfCarType = carTypeService.getAllCarType();
        } catch (Exception e) {
            log.error("Could not get the list of parking spot. ", e);
        }

        String message;

        ModelAndView modelAndView = new ModelAndView("reservation");

        if (potentialBooking.isEmpty()) {
            message = "Aucun véhicule trouvé pour cette recherche";
            modelAndView.addObject("message", message);
            modelAndView.addObject("cars", potentialBooking);

        } else {
            modelAndView.addObject("cars", potentialBooking);
        }

        modelAndView.addObject("setOfTown", setOfTown);
        modelAndView.addObject("listOfCarType", listOfCarType);
        modelAndView.addObject("filters", new FilterBookingOdt());

        return modelAndView;
    }
}
