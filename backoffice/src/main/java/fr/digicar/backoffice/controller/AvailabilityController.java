package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.CarService;
import fr.digicar.model.ParkingSpot;
import fr.digicar.model.Car;
import fr.digicar.odt.FilterBookingOdt;
import fr.digicar.backoffice.service.ParkingSpotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/reservation")
public class AvailabilityController {

    @Autowired
    private ParkingSpotService parkingSpotService;

//    @Autowired
//    private AvailabilityService availabilityService;
//
//    @Autowired
//    private CarService carService;
//
//    @Autowired
//    private OccupationService occupationService;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView getViewFoCarResevation() {


        ModelAndView modelAndView = new ModelAndView("reservation");
        List<ParkingSpot> listOfParkingSpot = new ArrayList<>();

        try {
            listOfParkingSpot = parkingSpotService.getParkingSpots();
        } catch (Exception e) {
            log.error("Could not get the list of parking spot. ", e);
        }

        modelAndView.addObject("listOfTown", listOfParkingSpot);
        modelAndView.addObject("filters", new FilterBookingOdt());

        return modelAndView;
    }

    @RequestMapping(value = "/findAvailableByCreteria", method = RequestMethod.POST)
    public ModelAndView getViewFoAvailableCar(@ModelAttribute("filters") final FilterBookingOdt filters) {

        ModelAndView modelAndView = new ModelAndView("reservation");

        String date = filters.getWishedDate();
        log.info("Date input: " + date);
        String startTime = filters.getStartTime();
        log.info("startTime input: " + startTime);
        String endTime = filters.getEndTime();
        log.info("endTime input: " + endTime);
        String zipCode = filters.getZipCode();
        log.info("zipCode input: " + zipCode);

        //List<Availability> listOfAvailability = availabilityService.availabilityByCriteria(date, startTime, endTime);

        List<Car> listOfAvailableCar = new ArrayList<>();

        Car car;
//        for (Availability availability : listOfAvailability) {
//            car = carService.getCarById(availability.getIdOccupation());
//            listOfAvailableCar.add(car);
//        }

        String message;
//        if ((listOfAvailability.size() == 0) || (listOfAvailableCar.size() == 0)) {
//            message = "Aucun véhicule disponible pour cette date";
//            modelAndView.addObject("message", message);
//            modelAndView.addObject("cars", listOfAvailableCar);
//        } else {
//            modelAndView.addObject("cars", listOfAvailableCar);
//        }


        return modelAndView;
    }

}

