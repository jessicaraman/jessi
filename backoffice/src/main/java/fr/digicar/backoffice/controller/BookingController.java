package fr.digicar.backoffice.controller;


import fr.digicar.backoffice.service.*;
import fr.digicar.model.*;
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
    private ReservationService reservationService;

    @Autowired
    private SpotAvailableService spotAvailableService;




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
        modelAndView.addObject("reservations", new ArrayList<>());

        return modelAndView;
    }

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
            modelAndView.addObject("reservations", potentialBooking);

        } else {
            modelAndView.addObject("reservations", potentialBooking);
        }

        modelAndView.addObject("setOfTown", setOfTown);
        modelAndView.addObject("listOfCarType", listOfCarType);
        modelAndView.addObject("filters", new FilterBookingOdt());

        return modelAndView;
    }

    @RequestMapping(value = "/submitBooking", method = RequestMethod.POST)
    public ModelAndView submitBooking(@ModelAttribute("reservationFilter") final ReservationOdt reservationFilter) {

        Set setOfTown = new TreeSet();
        List listOfCarType = new ArrayList();

        ParkingSpot parkingSpot = spotAvailableService.getSpotAvailableByIdLocation(reservationFilter.getCity());

        Reservation reservation = new Reservation();

        reservation.setId_car(reservationFilter.getIdCar());
        reservation.setId_parking_spots(reservationFilter.getIdParkingSpot());
        reservation.setStart_time(new Date(reservationFilter.getStartTime()));
        reservation.setEnd_time(new Date(reservationFilter.getEndTime()));
        reservation.setPlace_back(parkingSpot.getId());
        reservation.setId_user(1);
        reservation.setId_pricing(reservationFilter.getIdPrice());

        reservationService.addReservation(reservation);

        /*  lock car availability   */
        carAvailabilityService.updateCarAvailabilityId(reservation.getId_car(), "no");

        String submitMessage = null;

        ModelAndView modelAndView = new ModelAndView("reservation");

        try {

            setOfTown = parkingSpotService.getListOfLocation();
            listOfCarType = carTypeService.getAllCarType();
            modelAndView.addObject("reservationFilter", reservationFilter);
            submitMessage = "Réservation validée";

        } catch (Exception e) {
            log.error("Erreur when submitting reservation: "+e);
        }

        modelAndView.addObject("setOfTown", setOfTown);
        modelAndView.addObject("listOfCarType", listOfCarType);
        modelAndView.addObject("filters", new FilterBookingOdt());
        modelAndView.addObject("reservations", new ArrayList<>());
        modelAndView.addObject("reservationFilter", new ReservationOdt());
        modelAndView.addObject("message", submitMessage);




        return modelAndView;
    }
}
