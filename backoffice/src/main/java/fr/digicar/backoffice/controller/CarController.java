package fr.digicar.backoffice.controller;

import java.util.List;

import fr.digicar.model.Car;
import fr.digicar.backoffice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addCarPage() {
        ModelAndView modelAndView = new ModelAndView("add-car-form");
        modelAndView.addObject("car", new Car());
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addingCar(@ModelAttribute Car car) {

        ModelAndView modelAndView = new ModelAndView("home");
        carService.addCar(car);

        String message = car.getNbSpot() + " ont été ajoutées.";
        List<Car> cars = carService.getAllCar();
        modelAndView.addObject("car", cars);
        modelAndView.addObject("message", message);
        return modelAndView;
    }


}
