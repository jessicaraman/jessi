package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.CalculatedDelayService;
import fr.digicar.backoffice.service.CurrentSessionService;
import fr.digicar.model.CalculatedDelay;
import fr.digicar.model.CurrentSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private CalculatedDelayService calculatedDelayService;

    @Autowired
    private CurrentSessionService currentSessionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView addMonitorCoursePage() throws IOException {
        ModelAndView modelAndView = new ModelAndView("monitoring-course-form");
        modelAndView.addObject("ligneRetard", new CalculatedDelay());
        calculatedDelayService.deleteAllCalculatedDelays();
        calculatedDelayService.addCalculatedDelayAutomatically();
        List<CalculatedDelay> retardscalcule = calculatedDelayService.getCalculatedDelays(); //liste des personnes à appele
        return affichageMultiTable(retardscalcule, modelAndView);
    }

//   @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public ModelAndView addingParkingSpot(@ModelAttribute ParkingSpot parkingSpot) {
//
//        ModelAndView modelAndView = new ModelAndView("menu-parking-spot-form");
//        modelAndView.addObject("parking", new ParkingSpot());
//        parkingSpotService.addParkingSpot(parkingSpot);
//        String message = parkingSpot.getNbSpot() + " ont été ajoutées.";
//        List<ParkingSpot> parkingSpots = parkingSpotService.getParkingSpots();
//        modelAndView.addObject("parkingSpot", parkingSpots);
//        modelAndView.addObject("message", message);
//        return modelAndView;
//    }
//
//     @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
//     public ModelAndView searchingParkingSpot(@PathVariable int id) {
//
//         ModelAndView modelAndView = new ModelAndView("search-parking-spot-form");
//         ParkingSpot resultParkingSpot = parkingSpotService.getParkingSpot(id);
//         modelAndView.addObject("parkingSpot", resultParkingSpot);
//         return modelAndView;
//     }
//
//    @RequestMapping(value = "/search", method = RequestMethod.POST)
//    public ModelAndView searchingParkingSpot(@ModelAttribute ParkingSpot parkingSpot) {
//
//        ModelAndView modelAndView = new ModelAndView("menu-parking-spot-form");
//        modelAndView.addObject("parking", new ParkingSpot());
//        List<ParkingSpot> parkingSpots= parkingSpotService.getParkingSpotByObj(parkingSpot);
//       // ParkingSpot resultParkingSpot = parkingSpotService.getParkingSpot(parkingSpot.getId());
//        //parkingSpots.add(resultParkingSpot);
//        modelAndView.addObject("parkingSpot", parkingSpots);
//        return modelAndView;
//    }
//
//    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
//    public ModelAndView editParkingSpotPage(@PathVariable Integer id) {
//        ModelAndView modelAndView = new ModelAndView("menu-parking-spot-form");
//        modelAndView.addObject("parking", new ParkingSpot());
//        ParkingSpot parkingSpot = parkingSpotService.getParkingSpot(id);
//        modelAndView.addObject("place", parkingSpot);
//        return modelAndView;
//    }

    @RequestMapping(value = "/cloturer/{id}", method = RequestMethod.GET)
    public ModelAndView editingClotureLigneRetard(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("monitoring-course-form");
        modelAndView.addObject("ligneRetard", new CalculatedDelay());
        CalculatedDelay calculatedDelay = new CalculatedDelay();
        CurrentSession currentSession = new CurrentSession();
        calculatedDelay.setTagAppel(true);
        calculatedDelay.setId(id);
        currentSession.setId(calculatedDelayService.getCalculatedDelayById(id).getIdSession());
        currentSession.setTag(true);
        calculatedDelayService.updateCalculatedDelay(calculatedDelay);
        currentSessionService.updateCurrentSession(currentSession);
        List<CalculatedDelay> calculatedDelays = calculatedDelayService.getCalculatedDelays(); //liste des personnes à appele
        return affichageMultiTable(calculatedDelays, modelAndView);
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

//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public ModelAndView deleteParkingSpot(@PathVariable Integer id) {
//        ModelAndView modelAndView = new ModelAndView("menu-parking-spot-form");
//        modelAndView.addObject("parking", new ParkingSpot());
//        parkingSpotService.deleteParkingSpot(id);
//        String message = "une place supprime.";
//        List<ParkingSpot> parkingSpots = parkingSpotService.getParkingSpots();
//        modelAndView.addObject("parkingSpot", parkingSpots);
//        modelAndView.addObject("message", message);
//        return modelAndView;
//    }

}
