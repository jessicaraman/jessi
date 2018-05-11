package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.*;
import fr.digicar.model.*;
import fr.digicar.odt.ChosenvehicleOdt;
import fr.digicar.odt.CommercialGestureOdt;
import fr.digicar.odt.DisplayUserPreferencesOdt;
import fr.digicar.odt.FilterRegistrationIdOdt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/modifurgent")
public class MonitorSessionController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommercialGestureService commercialGestureService;

    @Autowired
    private CalculatedDelayService calculatedDelayService;

    @Autowired
    private CurrentSessionService currentSessionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView AddMonitorCoursePage() throws IOException {
        ModelAndView modelAndView = new ModelAndView("emergency-modification/monitoring-course-form");
        modelAndView.addObject("ligneRetard", new CalculatedDelay());
        calculatedDelayService.deleteAllCalculatedDelays();
        calculatedDelayService.addCalculatedDelayAutomatically();
        List<CalculatedDelay> retardscalcule = calculatedDelayService.getCalculatedDelays(); //liste des personnes à appele
        return affichageMultiTable(retardscalcule, modelAndView);
    }

    @RequestMapping(value = "/cloturer/{id}", method = RequestMethod.GET)
    public ModelAndView edditingClotureLigneRetard(@PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("emergency-modification/monitoring-course-form");
        modelAndView.addObject("ligneRetard", new CalculatedDelay());
        CalculatedDelay retardCalcule = new CalculatedDelay();
        CurrentSession sessionEnCours = new CurrentSession();
        retardCalcule.setTagAppel(true);
        retardCalcule.setId(id);
        sessionEnCours.setId(calculatedDelayService.getCalculatedDelayById(id).getIdSession());
        sessionEnCours.setTag(true);
        calculatedDelayService.updateCalculatedDelay(retardCalcule);
        currentSessionService.updateCurrentSession(sessionEnCours);
        List<CalculatedDelay> retardscalcule = calculatedDelayService.getCalculatedDelays(); //liste des personnes à appele
        return affichageMultiTable(retardscalcule, modelAndView);
    }

    @RequestMapping(value = "/impactedSession", method = RequestMethod.GET)
    public ModelAndView getImpactedAllBookings() {

        //Delay identified
        List<CalculatedDelay> retardscalcule = calculatedDelayService.getCalculatedDelays();

        //impacted bookings
        List<Booking> bookingImpacted = new ArrayList<>();

        List<Booking> allBookings = bookingService.getAllBookings();
        List<User> users = userService.searchUsers();

        String registration;
        String impact;
        for (CalculatedDelay aRetardscalcule : retardscalcule) {
            registration = aRetardscalcule.getRegistrationNumber();
            Long arrival= aRetardscalcule.getCalculatedReturnDateTime().getTime();

            for (Booking allBooking : allBookings) {

                impact = allBooking.getCar_registration_id();
                Long depart = allBooking.getDeparture_date().getTime();

                if (registration.equals(impact)) {
                    if (arrival > depart) {
                        bookingImpacted.add(allBooking);
                    }
                }
            }
        }
        ModelAndView modelAndView = new ModelAndView("emergency-modification/impacted-sessions");
        modelAndView.addObject("bookingImpacted", bookingImpacted);
        modelAndView.addObject("filteregistration", new FilterRegistrationIdOdt());
        modelAndView.addObject("AllUser", users);


        return modelAndView;
    }

    @RequestMapping(value = "/impactedSession/registrationId", method = RequestMethod.POST)
    public ModelAndView findSessionByregistrationId(@ModelAttribute("filteregistration") final FilterRegistrationIdOdt filterRegistrationIdOdt) {

        return findSession(filterRegistrationIdOdt);

    }

    @RequestMapping(value = "/impactedSession/{registrationId}", method = RequestMethod.GET)
    public ModelAndView getViewForUpdateSession(@PathVariable String registrationId) {
        FilterRegistrationIdOdt filterRegistrationIdOdt = new FilterRegistrationIdOdt();
        filterRegistrationIdOdt.setRegistrationNumber(registrationId);

        return findSession(filterRegistrationIdOdt);
    }

    @RequestMapping(value = "impactedSession/edditingImpactedSession/{bookingId}/{sessionInLateId}", method = RequestMethod.GET)
    public ModelAndView getViewForEdditingImpactedSession(@PathVariable int bookingId, @PathVariable int sessionInLateId) {

        List<Car> listOfCarforChoose = new ArrayList<>();

        //Exemple de car à afficher
        Car car = new Car();
        car.setId(490);
        car.setComfort(5);
        car.setTransmission(13);
        car.setFuelType(1);
        car.setKilometers(5);
        car.setBrandName("MAZDA");
        car.setModelName("MAZDA3");
        car.setDoorNumber(5);
        car.setSeatNumber(5);
        car.setRegistrationNumber("TZ-314-BA");
        car.setReleaseDate("2018-01-22");
        car.setType(4);

        listOfCarforChoose.add(car);

        List<CommercialGesture> commercialGestureList =commercialGestureService.getFirstCommercialGestureFree();

        ModelAndView modelAndView = new ModelAndView("emergency-modification/updateSession-or-commercialGesture");
        if(commercialGestureList.isEmpty()){
            modelAndView.addObject("bonreduction", "");

            String message = "Pas de reduction disponible Mettre à jour, veuillez rajouter des tokens";
            modelAndView.addObject("message", message);
        }
        else {
            String message = "";
            modelAndView.addObject("message", message);
            modelAndView.addObject("bon", commercialGestureList.get(0).getCode());
        }

        modelAndView.addObject("bookingId", bookingId);
        modelAndView.addObject("sessionInLateId", sessionInLateId);
        modelAndView.addObject("listOfCarforChoose", listOfCarforChoose);
        modelAndView.addObject("chosenvehicle", new ChosenvehicleOdt());
        modelAndView.addObject("commercialGesture", new CommercialGestureOdt());

        //TODO Algo de recherche de vehicule disponible selon pour client 2
        //Ajouter le nom du parking et l'adresse dans le tableau si possible
        //TODO liste de véhicule à proposer avec critère (le parking le plus proche) et afficher <marque modèle, comfort, emplacement de chaque véhicule>, et tenir compte de l'heure de départ souhaité et le confort proche du véhicule ancien

        return modelAndView;
    }

    @RequestMapping(value = "impactedSession/cancel/{bookingId}", method = RequestMethod.GET)
    public ModelAndView cancelBooking(@PathVariable int bookingId) {

        bookingService.removeBookingById(bookingId);
        return getImpactedAllBookings();
    }

    @RequestMapping(value = "/updateSession/{sessionInLateId}", method = RequestMethod.POST)
    public ModelAndView updateImpactedSession(@PathVariable int sessionInLateId, @ModelAttribute("chosenvehicle") final ChosenvehicleOdt chosenvehicleOdt) {

        //TODO traitement en masse à faire si temps

        bookingService.updateBookingById(chosenvehicleOdt.getBookingId(), chosenvehicleOdt.getCarId());

        return getImpactedAllBookings();
    }

    @RequestMapping(value = "/commercialGesture/{sessionInLateId}", method = RequestMethod.POST)
    public ModelAndView updateImpactedSession(@PathVariable int sessionInLateId, @ModelAttribute("commercialGesture") final CommercialGestureOdt commercialGestureOdt) {

        Booking booking = bookingService.getBooking(commercialGestureOdt.getBookingIdForCommercialFGesture());
        int id_user= booking.getId_user();

        commercialGestureService.updateCommercialGestureForUser(id_user, commercialGestureOdt.getBonCode());

        Timestamp returnDateTimeForDelaySession = calculatedDelayService.getCalculatedDelayById(sessionInLateId).getCalculatedReturnDateTime();
        bookingService.updateHourBooking(commercialGestureOdt.getBookingIdForCommercialFGesture(), returnDateTimeForDelaySession);

        //incrementer le tables users,
        userService.updateGestureAccountUser(id_user);

        return getImpactedAllBookings();
    }

    @RequestMapping(value = "/commercialGestureView", method = RequestMethod.GET)
    public ModelAndView getCommercialGestureView() {

        List<CommercialGesture> commercialGestureList =commercialGestureService.getAllCommeercialGesture();
        ModelAndView modelAndView = new ModelAndView("emergency-modification/commerciale_gesture");
        modelAndView.addObject("commercialGestureList", commercialGestureList);

        return modelAndView;
    }

    @RequestMapping(value = "/usersPreferencesView", method = RequestMethod.GET)
    public ModelAndView getusersPreferencesView() {

        List<User> users = userService.searchUsers();
        List<DisplayUserPreferencesOdt> userPreferencesOdtList = new ArrayList<>();
        for (User aUser : users) {

            DisplayUserPreferencesOdt displayUserPreferencesOdt = new DisplayUserPreferencesOdt();
            displayUserPreferencesOdt.setIdUser(aUser.getId());
            displayUserPreferencesOdt.setNumberOfDiscount(aUser.getNumberOfCommercialGesture());

            userPreferencesOdtList.add(displayUserPreferencesOdt);
        }

        ModelAndView modelAndView = new ModelAndView("emergency-modification/View_user_preferences");
        modelAndView.addObject("users", userPreferencesOdtList);

        return modelAndView;
    }

    @RequestMapping(value = "/reouvrir/{id}", method = RequestMethod.GET)
    public ModelAndView edditingReouvrirLigneRetard(@PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("monitoring-course-form");
        modelAndView.addObject("ligneRetard", new CalculatedDelay());
        CalculatedDelay calculatedDelay = new CalculatedDelay();
        CurrentSession sessionEnCours = new CurrentSession();
        calculatedDelay.setTagAppel(false);
        calculatedDelay.setId(id);
        sessionEnCours.setId(calculatedDelayService.getCalculatedDelayById(id).getIdSession());
        sessionEnCours.setTag(true);
        calculatedDelayService.updateCalculatedDelay(calculatedDelay);
        currentSessionService.updateCurrentSession(sessionEnCours);
        List<CalculatedDelay> retardscalcule = calculatedDelayService.getCalculatedDelays(); //liste des personnes à appele
        return affichageMultiTable(retardscalcule, modelAndView);
    }

    private ModelAndView affichageMultiTable(List<CalculatedDelay> retardscalcule, ModelAndView modelAndView) {
        List<CalculatedDelay> retardcalculesAppeler = new ArrayList<>();
        List<CalculatedDelay> retardcalculesNonEnRetard = new ArrayList<>();
        List<CalculatedDelay> retardcalculesNonAppeler = new ArrayList<>();

        for (CalculatedDelay r : retardscalcule) {
            if (r.getCalculatedReturnTime().getTime() <= r.getExpectedReturnTime().getTime()) {
                retardcalculesNonEnRetard.add(r);
            } else if (r.isTagAppel()) {
                retardcalculesAppeler.add(r);
            } else retardcalculesNonAppeler.add(r);
        }

        modelAndView.addObject("retardCalcule", retardcalculesNonAppeler);
        modelAndView.addObject("retardCalculeAppeler", retardcalculesAppeler);
        modelAndView.addObject("retardCalculeNonEnRetard", retardcalculesNonEnRetard);
        return modelAndView;
    }

    private ModelAndView findSession(FilterRegistrationIdOdt filterRegistrationIdOdt) {
        String registration = filterRegistrationIdOdt.getRegistrationNumber();
        String message;

        List<CalculatedDelay> retardscalcule = calculatedDelayService.getCalculatedDelays();
        Long arrival_time = null;
        int sessionId =0;

        for (CalculatedDelay aRetardscalcule : retardscalcule) {

            if (aRetardscalcule.getRegistrationNumber().equals(registration)) {

                arrival_time = aRetardscalcule.getCalculatedReturnDateTime().getTime();
                sessionId = aRetardscalcule.getId();
                break;
            }
        }

        List<Booking> bookingsimpacted = bookingService.getImpactedBookings(registration, arrival_time);
        List<User> users = userService.searchUsers();

        ModelAndView modelAndView = new ModelAndView("emergency-modification/impacted-sessions");
        modelAndView.addObject("filteregistration", new FilterRegistrationIdOdt());


        if (bookingsimpacted.isEmpty()) {
            message = "Veuillez Renseigner un matricule correcte";
            modelAndView.addObject("message", message);
        } else {
            modelAndView.addObject("bookingImpacted", bookingsimpacted);
            modelAndView.addObject("sessionInLateId", sessionId);
            modelAndView.addObject("AllUser", users);
        }
        return modelAndView;
    }
}
