package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.SpotAvailableService;
import fr.digicar.model.SpotAvailable;
import fr.digicar.odt.FilterBookingOdt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SpotAvailableController {

    @Autowired
    private SpotAvailableService spotAvailableService;

    @RequestMapping(value = "/updateSpotAvailable/{id_parking_spots}", method = RequestMethod.GET)
    public ModelAndView getViewForUpdateCar(@PathVariable int id_parking_spots) {
        SpotAvailable spotAvailable = spotAvailableService.getSpotAvailableById(id_parking_spots);

        ModelAndView modelAndView = new ModelAndView("spotAvailable/update-spot_available");
        modelAndView.addObject("spotAvailable", spotAvailable);


        return modelAndView;
    }

    @RequestMapping(value = "/allspotsavailable", method = RequestMethod.POST)
    public ModelAndView findSpotAvailableById(@ModelAttribute("filters") final FilterBookingOdt filters) {


        List<SpotAvailable> allSpotsAvailableList = spotAvailableService.getAllSpotsAvailable();

        String message;
        List<SpotAvailable> spotsAvailable = new ArrayList<>();

        ModelAndView modelAndView = new ModelAndView("spotsAvailable");

        String date = filters.getWishedDate();
        log.info("Date input: " + date);
        String startTime = filters.getStartTime();
        log.info("startTime input: " + startTime);
        String endTime = filters.getEndTime();
        log.info("endTime input: " + endTime);
        String zipCode = filters.getZipCode();
        log.info("zipCode input: " + zipCode);

        if (allSpotsAvailableList.isEmpty()) {
            message = "Aucun véhicule trouvé pour cette recherche";
            modelAndView.addObject("message", message);
            modelAndView.addObject("carAvailabilities", spotsAvailable);
        } else {
            modelAndView.addObject("carAvailabilities", allSpotsAvailableList);
        }

        return modelAndView;
    }

}
