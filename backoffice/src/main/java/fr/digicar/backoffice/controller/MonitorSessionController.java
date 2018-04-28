package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.CalculatedDelayService;
import fr.digicar.backoffice.service.CurrentSessionService;
import fr.digicar.backoffice.service.SessionService;
import fr.digicar.model.CalculatedDelay;
import fr.digicar.model.Car;
import fr.digicar.model.CurrentSession;
import fr.digicar.model.Session;
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
    private SessionService sessionService;

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
        CalculatedDelay calculatedDelay = new CalculatedDelay();
        CurrentSession currentSession = new CurrentSession();
        calculatedDelay.setTagAppel(true);
        calculatedDelay.setId(id);
        currentSession.setId(calculatedDelayService.getCalculatedDelayById(id).getIdSession());
        currentSession.setTag(true);
        calculatedDelayService.updateCalculatedDelay(calculatedDelay);
        currentSessionService.updateCurrentSession(currentSession);
        List<CalculatedDelay> retardscalcule = calculatedDelayService.getCalculatedDelays(); //liste des personnes à appele
        return affichageMultiTable(retardscalcule, modelAndView);
    }

    @RequestMapping(value = "/impactedSession", method = RequestMethod.GET)
    public ModelAndView getImpactedAllSessions() {

        //Delay identified
        List<CalculatedDelay> retardscalcule = calculatedDelayService.getCalculatedDelays();

        //impacted sessions
        List<Session> sessionimpacted = new ArrayList<>();

        List<Session> allSession = sessionService.getAllSessions();
        String registration;
        String impact;
        for (CalculatedDelay aRetardscalcule : retardscalcule) {
            registration = aRetardscalcule.getRegistrationNumber();
            Long t1 = aRetardscalcule.getCalculatedReturnTime().getTime();

            for (Session anAllSession : allSession) {
                impact = anAllSession.getCar_registration_id();
                Long t2 = anAllSession.getDepartureDate().getTime();

                if (registration.equals(impact)) {
                    if (t1 >= t2) {
                        sessionimpacted.add(anAllSession);
                    }
                }
            }
        }
        ModelAndView modelAndView = new ModelAndView("emergency-modification/impacted-sessions");
        modelAndView.addObject("sessionimpacted", sessionimpacted);
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

    @RequestMapping(value = "/edditingImpactedSession/{sessionId}", method = RequestMethod.GET)
    public ModelAndView getViewForEdditingImpactedSession(@PathVariable int sessionId) {

        List<Car> listOfCarforChoose = new ArrayList<>();
        //Ajouter le nom du parking et l'adresse dans le tableau si possible
        String bonReduction = "Aucun";      //Soit afficher aucun bon à l'offrir ou le numéro du bon

        List<ChosenvehicleOdt> chosenVehicleOdts = new ArrayList<>();

        ModelAndView modelAndView = new ModelAndView("emergency-modification/updateSession-or-commercialGesture");
        modelAndView.addObject("sessionId", sessionId);
        modelAndView.addObject("bonreduction", bonReduction);
        modelAndView.addObject("chosenvehicle", chosenVehicleOdts);
        modelAndView.addObject("commercialGesture", new CommercialGestureOdt());

        //TODO liste de véhicule à proposer avec critère (le parking le plus proche) et afficher <marque modèle, comfort, emplacement de chaque véhicule>, et tenir compte de l'heure de départ souhaité et le confort proche du véhicule ancien
        //TODO Générer un bon de réduction à afficher puis à envoyer le bon par mail puis annuler reservation. Voir jessica comment faire pour générer le bon

        return modelAndView;
    }

    @RequestMapping(value = "/cancel/{sessionId}", method = RequestMethod.GET)
    public ModelAndView cancelSession(@PathVariable int sessionId) {

        sessionService.removeSessionById(sessionId);
        //TODO vérifier si les réservations sont dans la table session
        return getImpactedAllSessions();
    }

    @RequestMapping(value = "/updateSession", method = RequestMethod.POST)
    public ModelAndView updateImpactedSession(@ModelAttribute("chosenvehicle") final ChosenvehicleOdt chosenvehicleOdt) {

        sessionService.updateSessionById(chosenvehicleOdt.getsessionId(), chosenvehicleOdt.getcarId());
        //TODO vérifier si les réservations sont dans la table session

        return getImpactedAllSessions();
    }

    @RequestMapping(value = "/commercialGesture", method = RequestMethod.POST)
    public ModelAndView updateImpactedSession(@ModelAttribute("commercialGesture") final CommercialGestureOdt commercialGestureOdt) {

        //TODO sauvegarder le bon de reduction pour le client, creer table de bon ou mettre dans le compte client
        //TODO vérifier si les réservations sont dans la table session

        return getImpactedAllSessions();
    }

    @RequestMapping(value = "/reouvrir/{id}", method = RequestMethod.GET)
    public ModelAndView editingReouvrirLigneRetard(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("monitoring-course-form");
        modelAndView.addObject("ligneRetard", new CalculatedDelay());
        CalculatedDelay calculatedDelay = new CalculatedDelay();
        CurrentSession currentSession = new CurrentSession();
        calculatedDelay.setTagAppel(false);
        calculatedDelay.setId(id);
        currentSession.setId(calculatedDelayService.getCalculatedDelayById(id).getIdSession());
        currentSession.setTag(true);
        calculatedDelayService.updateCalculatedDelay(calculatedDelay);
        currentSessionService.updateCurrentSession(currentSession);
        List<CalculatedDelay> retardscalcule = calculatedDelayService.getCalculatedDelays(); //liste des personnes à appele
        return affichageMultiTable(retardscalcule, modelAndView);
    }

    private ModelAndView affichageMultiTable(List<CalculatedDelay> retardscalcule, ModelAndView modelAndView) {
        List<CalculatedDelay> calledCalculatedDelays = new ArrayList<>();
        List<CalculatedDelay> notLateCalculatedDelays = new ArrayList<>();
        List<CalculatedDelay> notCalledCalulatedDelays = new ArrayList<>();

        for (CalculatedDelay r : retardscalcule) {
            if (r.getCalculatedReturnTime().getTime() <= r.getExpectedReturnTime().getTime()) {
                notLateCalculatedDelays.add(r);
            } else if (r.isTagAppel()) {
                calledCalculatedDelays.add(r);
            } else notCalledCalulatedDelays.add(r);
        }

        modelAndView.addObject("retardCalcule", notCalledCalulatedDelays);
        modelAndView.addObject("retardCalculeAppeler", calledCalculatedDelays);
        modelAndView.addObject("retardCalculeNonEnRetard", notLateCalculatedDelays);
        return modelAndView;
    }

    private ModelAndView findSession(FilterRegistrationIdOdt filterRegistrationIdOdt) {
        String registration = filterRegistrationIdOdt.getRegistrationNumber();
        String message;

        List<CalculatedDelay> calculatedDelays = calculatedDelayService.getCalculatedDelays();
        Long arrivalTime = null;

        for (CalculatedDelay aRetardscalcule : calculatedDelays) {
            if (aRetardscalcule.getRegistrationNumber().equals(registration)) {
                arrivalTime = aRetardscalcule.getCalculatedReturnTime().getTime();
                break;
            }
        }

        List<Session> impactedSessions = sessionService.getImpactedSessions(registration, arrivalTime);

        ModelAndView modelAndView = new ModelAndView("emergency-modification/impacted-sessions");
        modelAndView.addObject("filteregistration", new FilterRegistrationIdOdt());

        if (impactedSessions.isEmpty()) {
            message = "Veuillez Renseigner un matricule correcte";
            modelAndView.addObject("message", message);
        } else {
            modelAndView.addObject("sessionimpacted", impactedSessions);
        }
        return modelAndView;
    }
}
