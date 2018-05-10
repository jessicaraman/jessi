package fr.digicar.backoffice.controller;


import fr.digicar.backoffice.service.CarAvailabilityService;
import fr.digicar.backoffice.service.ParkingSpotService;
import fr.digicar.model.CarAvailability;
import fr.digicar.model.ParkingSpot;
import fr.digicar.odt.FilterBookingOdt;
import fr.digicar.odt.FilterOdt;
import fr.digicar.odt.FilterRegistrationIdOdt;
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
public class CarAvailabilityController {

    @Autowired
    private CarAvailabilityService carAvailabilityService;

    @Autowired
    private ParkingSpotService parkingSpotService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView getViewFoCarResevation() {


        ModelAndView modelAndView = new ModelAndView("reservation");
        List listOfParkingSpot = new ArrayList<>();
        Set setOfTown = null;

        try {
            listOfParkingSpot = parkingSpotService.getParkingSpots();
            setOfTown =  new HashSet(listOfParkingSpot);
        } catch (Exception e) {
            log.error("Could not get the list of parking spot. ", e);
        }

        modelAndView.addObject("setOfTown", setOfTown);
        modelAndView.addObject("filters", new FilterBookingOdt());

        return modelAndView;
    }

    @RequestMapping(value = "/allcaravailabilities", method = RequestMethod.POST)
    public ModelAndView findCarAvailabilityByCriteria(@ModelAttribute("filters") final FilterBookingOdt filters) {


        List<CarAvailability> allCarAvailabilityList = carAvailabilityService.getAllCarAvailabilities();

        String message;
        List<CarAvailability> carAvailabilities = new ArrayList<>();

        ModelAndView modelAndView = new ModelAndView("reservation");

        String date = filters.getWishedDate();
        log.info("Date input: " + date);
        String startTime = filters.getStartTime();
        log.info("startTime input: " + startTime);
        String endTime = filters.getEndTime();
        log.info("endTime input: " + endTime);
        String zipCode = filters.getZipCode();
        log.info("zipCode input: " + zipCode);

        if (allCarAvailabilityList.isEmpty()) {
            message = "Aucun véhicule trouvé pour cette recherche";
            modelAndView.addObject("message", message);
            modelAndView.addObject("carAvailabilities", carAvailabilities);
        } else {
            modelAndView.addObject("carAvailabilities", allCarAvailabilityList);
        }

        return modelAndView;
    }
}
