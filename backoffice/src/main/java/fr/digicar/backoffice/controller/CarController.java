package fr.digicar.backoffice.controller;

import java.util.List;

import fr.digicar.model.Car;
import fr.digicar.backoffice.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller

public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public ModelAndView addCarPage() {
        ModelAndView modelAndView = new ModelAndView("add-car-form");
        modelAndView.addObject("car", new Car());
        return modelAndView;
    }

    @RequestMapping(value = "/car/add", method = RequestMethod.POST)
    public ModelAndView addingCar(@ModelAttribute ("car") Car car, BindingResult result) {
        log.debug(car.getRegistration_number());
        carService.addCar(car);

        ModelAndView modelAndView = new ModelAndView("add-car-form");
        String message = "Le véhicule " + car.getRegistration_number() + " a été ajouté.";
        List<Car> cars = carService.getCars();
        modelAndView.addObject("car", cars);
        modelAndView.addObject("message", message);
        return modelAndView;
    }


}
