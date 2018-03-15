package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.RetardCalculeService;


import fr.digicar.backoffice.service.SessionEnCoursService;
import fr.digicar.model.RetardCalcule;
<<<<<<< HEAD
import fr.digicar.model.SessionEnCours;
=======
import org.json.JSONException;
>>>>>>> da59a1f040c909ddc8f69e3ab2aa07b992041463
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> da59a1f040c909ddc8f69e3ab2aa07b992041463
import java.util.List;


@Controller
@RequestMapping(value = "/modifurgent")
public class MonitorSessionController {

    @Autowired
    private RetardCalculeService retardCalculeService;

    @Autowired
    private SessionEnCoursService sessionEnCoursService;







    @RequestMapping(value = "", method = RequestMethod.GET)
<<<<<<< HEAD
    public ModelAndView AddMonitorCoursePage() throws IOException {
        ModelAndView modelAndView = new ModelAndView("monitoring-course-form");
        modelAndView.addObject("ligneRetard", new RetardCalcule());
        retardCalculeService.deleteAllRetardsCalcule();
        retardCalculeService.addRetardCalculeAutomatically();
        List<RetardCalcule> retardscalcule = retardCalculeService.getRetardsCalcule(); //liste des personnes à appele
        List<RetardCalcule> retardcalculesAppeler=new ArrayList<RetardCalcule>(); //liste des personnes déjà appeler
        List<RetardCalcule> retardcalculesNonEnRetard=new ArrayList<RetardCalcule>();
        List<RetardCalcule> retardcalculesNonAppeler=new ArrayList<RetardCalcule>();

        for(RetardCalcule r : retardscalcule){
            int i=0;
            System.out.println("ls retard a appelr : "+retardscalcule.size()+"  "+i);
            if(r.getHeureRetourCalcule().getTime()<=r.getHeureRetourPrevu().getTime()){
                retardcalculesNonEnRetard.add(r);

            }
            else if (r.getTagAppel() == true) {
                retardcalculesAppeler.add(r);
            }
            else retardcalculesNonAppeler.add(r);
        }
        modelAndView.addObject("retardCalcule", retardcalculesNonAppeler);
        modelAndView.addObject("retardCalculeAppeler", retardcalculesAppeler);
        modelAndView.addObject("retardCalculeNonEnRetard", retardcalculesNonEnRetard);
=======
    public ModelAndView AddMonitorCoursePage() throws IOException, JSONException {
        ModelAndView modelAndView = new ModelAndView("monitoring-course-form");
        modelAndView.addObject("ligneRetard", new RetardCalcule());
        retardCalculeService.addRetardCalculeAutomatically();
        List<RetardCalcule> retardscalcule = retardCalculeService.getRetardsCalcule();//ajouter condition de sup
        modelAndView.addObject("retardCalcule", retardscalcule);
>>>>>>> da59a1f040c909ddc8f69e3ab2aa07b992041463
        return modelAndView;
    }

   /* @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addingParkingSpot(@ModelAttribute ParkingSpot parkingSpot) {

        ModelAndView modelAndView = new ModelAndView("menu-parking-spot-form");
        modelAndView.addObject("parking", new ParkingSpot());
        parkingSpotService.addParkingSpot(parkingSpot);
        String message = parkingSpot.getNbSpot() + " ont été ajoutées.";
        List<ParkingSpot> parkingSpots = parkingSpotService.getParkingSpots();
        modelAndView.addObject("parkingSpot", parkingSpots);
        modelAndView.addObject("message", message);
        return modelAndView;
    }*/

   /* @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
    public ModelAndView searchingParkingSpot(@PathVariable int id) {

        ModelAndView modelAndView = new ModelAndView("search-parking-spot-form");
        ParkingSpot resultParkingSpot = parkingSpotService.getParkingSpot(id);
        modelAndView.addObject("parkingSpot", resultParkingSpot);
        return modelAndView;
    }*/
/*
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView searchingParkingSpot(@ModelAttribute ParkingSpot parkingSpot) {

        ModelAndView modelAndView = new ModelAndView("menu-parking-spot-form");
        modelAndView.addObject("parking", new ParkingSpot());
        List<ParkingSpot> parkingSpots= parkingSpotService.getParkingSpotByObj(parkingSpot);
       // ParkingSpot resultParkingSpot = parkingSpotService.getParkingSpot(parkingSpot.getId());
        //parkingSpots.add(resultParkingSpot);
        modelAndView.addObject("parkingSpot", parkingSpots);
        return modelAndView;
    }


    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editParkingSpotPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("menu-parking-spot-form");
        modelAndView.addObject("parking", new ParkingSpot());
        ParkingSpot parkingSpot = parkingSpotService.getParkingSpot(id);
        modelAndView.addObject("place", parkingSpot);
        return modelAndView;
    }
*/
    @RequestMapping(value = "/cloturer/{id}", method = RequestMethod.GET)
    public ModelAndView edditingClotureLigneRetard(@PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("monitoring-course-form");
        modelAndView.addObject("ligneRetard", new RetardCalcule());
        RetardCalcule retardCalcule=new RetardCalcule();
        SessionEnCours sessionEnCours=new SessionEnCours();
        retardCalcule.setTagAppel(true);
        retardCalcule.setId(id);
        sessionEnCours.setIdSession(retardCalculeService.getRetardCalcule(id).getIdSession());
        sessionEnCours.setTag(true);
        retardCalculeService.updateRetardCalcule(retardCalcule);
        sessionEnCoursService.updateSessionEnCours(sessionEnCours);
        List<RetardCalcule> retardscalcule = retardCalculeService.getRetardsCalcule(); //liste des personnes à appele
        return AffichageMultiTable(retardscalcule,modelAndView);
    }

    @RequestMapping(value = "/reouvrir/{id}", method = RequestMethod.GET)
    public ModelAndView edditingReouvrirLigneRetard(@PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("monitoring-course-form");
        modelAndView.addObject("ligneRetard", new RetardCalcule());
        RetardCalcule retardCalcule=new RetardCalcule();
        SessionEnCours sessionEnCours=new SessionEnCours();
        retardCalcule.setTagAppel(false);
        retardCalcule.setId(id);
        sessionEnCours.setIdSession(retardCalculeService.getRetardCalcule(id).getIdSession());
        sessionEnCours.setTag(true);
        retardCalculeService.updateRetardCalcule(retardCalcule);
        sessionEnCoursService.updateSessionEnCours(sessionEnCours);
        List<RetardCalcule> retardscalcule = retardCalculeService.getRetardsCalcule(); //liste des personnes à appele
       return AffichageMultiTable(retardscalcule,modelAndView);
    }

    public ModelAndView AffichageMultiTable(List<RetardCalcule> retardscalcule,ModelAndView modelAndView ){
        List<RetardCalcule> retardcalculesAppeler=new ArrayList<RetardCalcule>();
        List<RetardCalcule> retardcalculesNonEnRetard=new ArrayList<RetardCalcule>();
        List<RetardCalcule> retardcalculesNonAppeler=new ArrayList<RetardCalcule>();

        for(RetardCalcule r : retardscalcule){
            if(r.getHeureRetourCalcule().getTime()<=r.getHeureRetourPrevu().getTime()){
                retardcalculesNonEnRetard.add(r);
            }
            else if (r.getTagAppel() == true) {
                retardcalculesAppeler.add(r);
            }
            else retardcalculesNonAppeler.add(r);
        }

        modelAndView.addObject("retardCalcule", retardcalculesNonAppeler);
        modelAndView.addObject("retardCalculeAppeler", retardcalculesAppeler);
        modelAndView.addObject("retardCalculeNonEnRetard", retardcalculesNonEnRetard);
        return modelAndView;
    }

/*
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteParkingSpot(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("menu-parking-spot-form");
        modelAndView.addObject("parking", new ParkingSpot());
        parkingSpotService.deleteParkingSpot(id);
        String message = "une place supprime.";
        List<ParkingSpot> parkingSpots = parkingSpotService.getParkingSpots();
        modelAndView.addObject("parkingSpot", parkingSpots);
        modelAndView.addObject("message", message);
        return modelAndView;
    }
*/
}
