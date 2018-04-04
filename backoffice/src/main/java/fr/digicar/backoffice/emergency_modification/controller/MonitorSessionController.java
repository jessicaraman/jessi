package fr.digicar.backoffice.emergency_modification.controller;

import fr.digicar.backoffice.emergency_modification.service.RetardCalculeService;

import fr.digicar.backoffice.emergency_modification.service.SessionEnCoursService;
import fr.digicar.model.RetardCalcule;

import fr.digicar.model.SessionEnCours;
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
    private RetardCalculeService retardCalculeService;

    @Autowired
    private SessionEnCoursService sessionEnCoursService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView AddMonitorCoursePage() throws IOException{
        ModelAndView modelAndView = new ModelAndView("monitoring-course-form");
        modelAndView.addObject("ligneRetard", new RetardCalcule());
        retardCalculeService.deleteAllRetardsCalcule();
        retardCalculeService.addRetardCalculeAutomatically();
        List<RetardCalcule> retardscalcule = retardCalculeService.getRetardsCalcule(); //liste des personnes à appele
        return AffichageMultiTable(retardscalcule,modelAndView);
    }

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

}
