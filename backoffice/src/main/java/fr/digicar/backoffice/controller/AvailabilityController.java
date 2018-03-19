package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.AvailabilityService;
import fr.digicar.backoffice.service.CarService;
import fr.digicar.backoffice.service.OccupationService;
import fr.digicar.model.Availability;
import fr.digicar.model.Occupation;
import fr.digicar.model.ParkingSpot;
import fr.digicar.model.Car;
import fr.digicar.odt.FilterReservationOdt;
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

    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private CarService carService;

    @Autowired
    private OccupationService occupationService;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView getViewFoCarResevation() {


        ModelAndView modelAndView = null;
        List<ParkingSpot> listOfParkingSpot = null;

        try {
            modelAndView = new ModelAndView("reservation");
            listOfParkingSpot = parkingSpotService.getParkingSpots();
            modelAndView.addObject("listOfTown", listOfParkingSpot);
            modelAndView.addObject("filters", new FilterReservationOdt());
        }catch (Exception e){
            log.error("Localize message: "+e.getLocalizedMessage());
            log.error("Simple Message: "+e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/findAvailableByCreteria", method = RequestMethod.POST)
    public ModelAndView getViewFoAvailableCar(@ModelAttribute("filters") final FilterReservationOdt filters) {

        ModelAndView modelAndView = new ModelAndView("reservation");


        String date = filters.getWishedDate();
        log.info("Date input: "+date);
        String start_time = filters.getStart_time();
        log.info("start_time input: "+start_time);
        String end_time = filters.getEnd_time();
        log.info("end_time input: "+end_time);
        String postal_code = filters.getPostal_code();
        log.info("postal_code input: "+postal_code);

        List<Availability> listOfAvailability = availabilityService.availabilityByCreteria(date,start_time,end_time);

        List<Car> listOfAvailableCar = new ArrayList<Car>();

        Car car;
        for(Availability availability: listOfAvailability){
            car = carService.getCarById(availability.getId_occupation());
            listOfAvailableCar.add(car);
        }

        String message;
        if((listOfAvailability.size() == 0) || (listOfAvailableCar.size() == 0)){
            message = "Aucun véhicule disponible pour cette date";
            modelAndView.addObject("message", message);
            modelAndView.addObject("cars", listOfAvailableCar);
        }
        else{
            modelAndView.addObject("cars", listOfAvailableCar);
        }


        return modelAndView;
    }

}

