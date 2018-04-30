package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.BookingService;
import fr.digicar.backoffice.service.CalculatedDelayService;
import fr.digicar.backoffice.service.CurrentSessionService;
import fr.digicar.model.Booking;
import fr.digicar.model.CalculatedDelay;
import fr.digicar.model.Car;
import fr.digicar.model.CurrentSession;
import fr.digicar.odt.ChosenvehicleOdt;
import fr.digicar.odt.CommercialGestureOdt;
import fr.digicar.odt.FilterRegistrationIdOdt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/modifurgent")
public class MonitorSessionController {

    @Autowired
    private BookingService bookingService;

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
        List<Booking> bookingsimpacted = new ArrayList<>();

        List<Booking> allBookings = bookingService.getAllBookings();
        String registration;
        String impact;
        for (CalculatedDelay aRetardscalcule : retardscalcule) {
            registration = aRetardscalcule.getRegistrationNumber();
            Long t1 = aRetardscalcule.getCalculatedReturnTime().getTime();

            for (Booking allBooking : allBookings) {

                impact = allBooking.getCar_registration_id();
                Long t2 = allBooking.getDeparture_date().getTime();

                if (registration.equals(impact)) {
                    if (t1 >= t2) {
                        bookingsimpacted.add(allBooking);
                    }
                }
            }
        }
        ModelAndView modelAndView = new ModelAndView("emergency-modification/impacted-sessions");
        modelAndView.addObject("bookingimpacted", bookingsimpacted);
        modelAndView.addObject("filteregistration", new FilterRegistrationIdOdt());

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

    @RequestMapping(value = "/edditingImpactedSession/{bookingId}", method = RequestMethod.GET)
    public ModelAndView getViewForEdditingImpactedSession(@PathVariable int bookingId) {

        List<Car> listOfCarforChoose = new ArrayList<>();
        //TODO Algo de recherche de vehicule disponible selon pour client 2
        //Ajouter le nom du parking et l'adresse dans le tableau si possible
        String bonReduction = "Aucun";      //Soit afficher aucun bon à l'offrir ou le numéro du bon

        List<ChosenvehicleOdt> chosenvehicleOdts = new ArrayList<>();

        ModelAndView modelAndView = new ModelAndView("emergency-modification/updateSession-or-commercialGesture");
        modelAndView.addObject("bookingId", bookingId);
        modelAndView.addObject("bonreduction", bonReduction);
        modelAndView.addObject("chosenvehicle", chosenvehicleOdts);
        modelAndView.addObject("commercialGesture", new CommercialGestureOdt());

        //TODO liste de véhicule à proposer avec critère (le parking le plus proche) et afficher <marque modèle, comfort, emplacement de chaque véhicule>, et tenir compte de l'heure de départ souhaité et le confort proche du véhicule ancien
        //TODO Générer un bon de réduction à afficher puis à envoyer le bon par mail puis annuler reservation. Voir jessica comment faire pour générer le bon

        return modelAndView;
    }

    @RequestMapping(value = "/cancel/{bookingId}", method = RequestMethod.GET)
    public ModelAndView cancelBooking(@PathVariable int bookingId) {

        bookingService.removeBookingById(bookingId);
        //TODO vérifier si les réservations sont dans la table session
        return getImpactedAllBookings();
    }

    @RequestMapping(value = "/updateSession", method = RequestMethod.POST)
    public ModelAndView updateImpactedSession(@ModelAttribute("chosenvehicle") final ChosenvehicleOdt chosenvehicleOdt) {

        bookingService.updateBookingById(chosenvehicleOdt.getbookingId(), chosenvehicleOdt.getcarId());
        //TODO vérifier si les réservations sont dans la table session

        return getImpactedAllBookings();
    }

    @RequestMapping(value = "/commercialGesture", method = RequestMethod.POST)
    public ModelAndView updateImpactedSession(@ModelAttribute("commercialGesture") final CommercialGestureOdt commercialGestureOdt) {

        //TODO sauvegarder le bon de reduction pour le client, creer table de bon ou mettre dans le compte client

        //TODO vérifier si les réservations sont dans la table session

        return getImpactedAllBookings();
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

        for (CalculatedDelay aRetardscalcule : retardscalcule) {

            if (aRetardscalcule.getRegistrationNumber().equals(registration)) {

                arrival_time = aRetardscalcule.getCalculatedReturnTime().getTime();
                break;
            }
        }

        List<Booking> bookingsimpacted = bookingService.getImpactedBookings(registration, arrival_time);

        ModelAndView modelAndView = new ModelAndView("emergency-modification/impacted-sessions");
        modelAndView.addObject("filteregistration", new FilterRegistrationIdOdt());

        if (bookingsimpacted.isEmpty()) {
            message = "Veuillez Renseigner un matricule correcte";
            modelAndView.addObject("message", message);
        } else {
            modelAndView.addObject("bookingImpacted", bookingsimpacted);
        }
        return modelAndView;
    }
}
