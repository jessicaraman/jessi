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

        String date = filters.getWishedDate();
        log.info("Date input: " + date);
        String startTime = filters.getStartTime();
        log.info("startTime input: " + startTime);
        String endTime = filters.getEndTime();
        log.info("endTime input: " + endTime);
        String city = filters.getCity();
        log.info("city input: " + city);
        int idCarType = Integer.parseInt(filters.getCarType());
        log.info("idCarType input: " + idCarType);

        List<CarAvailability> carsAvailable = new ArrayList<>();
        List<ReservationOdt> potentialBooking = new ArrayList<>();
        Set setOfTown = new TreeSet();
        List listOfCarType = new ArrayList();

        try {
            carsAvailable = carAvailabilityService.getCarAvailabilityBy(city, idCarType);
            log.info("Size of carsAvailable : " + carsAvailable.size());
            for (CarAvailability carAvailability : carsAvailable) {
                Car car = carService.getCarById(carAvailability.getId_car());
                ParkingSpot parkingSpot = parkingSpotService.getParkingSpot(carAvailability.getId_parking_spots());

                String mark = car.getBrandName();
                log.info("mark: " + mark);
                String model = car.getModelName();
                log.info("model: " + model);
                int doorsNumber = car.getDoorNumber();
                log.info("doorsNumber: " + doorsNumber);
                String parkingAddress = (parkingService.getParkingById(Integer.parseInt(parkingSpot.getNbParking()))).getRoad_name();

                potentialBooking.add(new ReservationOdt(mark, model, doorsNumber, parkingAddress));
            }

            setOfTown = parkingSpotService.getListOfLocation();
            listOfCarType = carTypeService.getAllCarType();
        } catch (Exception e) {
            log.error("Could not get the list of parking spot. ", e);
        }

        String message;

        ModelAndView modelAndView = new ModelAndView("reservation");

        if (carsAvailable.isEmpty()) {
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
