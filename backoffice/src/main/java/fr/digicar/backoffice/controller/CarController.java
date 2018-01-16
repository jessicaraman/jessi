package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.CarService;
import fr.digicar.model.Car;
import fr.digicar.odt.FilterOdt;
import fr.digicar.odt.FilterRegistrationIdOdt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView("car/home-car-referential");
        modelAndView.addObject("filteregistration", new FilterRegistrationIdOdt());
        modelAndView.addObject("filters", new FilterOdt());
        modelAndView.addObject("car", new Car());
        List<Car> cars = carService.getCars();
        modelAndView.addObject("cars", cars);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addingCar(@ModelAttribute("car") Car car, BindingResult result) {
        carService.addCar(car);

        ModelAndView modelAndView = new ModelAndView("car/home-car-referential");
        Car addedCar = car;
        List<Car> cars = carService.getCars();
        modelAndView.addObject("addedCar", addedCar);
        modelAndView.addObject("filteregistration", new FilterRegistrationIdOdt());
        modelAndView.addObject("filter", new FilterOdt());
        modelAndView.addObject("cars", cars);
        return modelAndView;
    }

    @RequestMapping(value = "/addCarPage", method = RequestMethod.GET)
    public ModelAndView addingCar() {

        ModelAndView modelAndView = new ModelAndView("car/add-car-form");
        modelAndView.addObject("car", new Car());
        return modelAndView;
    }

    @RequestMapping(value = "/registrationId", method = RequestMethod.POST)
    public ModelAndView getCarByRegistrationId(@ModelAttribute("filteregistration") final FilterRegistrationIdOdt filterRegistrationIdOdt) {
        String registration = filterRegistrationIdOdt.getregistrationNumber();
        String message = "";

        List<Car> cars = carService.getCars();

        Car car = new Car();
        Boolean check = false;
        String registrationId =null;
        for (int i=0; i<cars.size(); i++){
            car = cars.get(i);
            registrationId = car.getRegistration_number();
            if(registrationId.equals(registration)){
                check= true;
                break;
            }
        }

        ModelAndView modelAndView = new ModelAndView("car/home-car-referential");
        modelAndView.addObject("car", new Car());
        modelAndView.addObject("filters", new FilterOdt());

        if (check==false){
            message = "Veuillez Renseigner un matricule correcte ou utiliser la recherche générale";
            modelAndView.addObject("message", message);
            return modelAndView;

        }
        else {

            List<Car> carFilter = new ArrayList<>();
            carFilter.add(car);

            modelAndView.addObject("cars", carFilter);
            return modelAndView;
        }
    }
    @RequestMapping(value = "/allcars", method = RequestMethod.POST)
    public ModelAndView getAllCars(@ModelAttribute("filters") final FilterOdt filterOdt)
    {
        String carBrand = filterOdt.getCarBrand();
        String modelName = filterOdt.getModelName();
        List<Car> allCars = carService.getCars();
        String message="";

        Car car;
        List<Car> carsFind = new ArrayList<>();
        for (int i=0; i<allCars.size(); i++){
            car = allCars.get(i);
            if(carBrand.equals(car.getMark()) && modelName.equals(car.getName_model())){
                carsFind.add(car);
            }
        }
        ModelAndView modelAndView = new ModelAndView("car/home-car-referential");

        modelAndView.addObject("car", new Car());
        modelAndView.addObject("filters", new FilterOdt());
        modelAndView.addObject("filteregistration", new FilterRegistrationIdOdt());

        if(carsFind.isEmpty()){
            message = "Aucun véhicule trouvé pour cette rechercher";
            modelAndView.addObject("message", message);
            modelAndView.addObject("cars", carsFind);
        }
        else{
            modelAndView.addObject("cars", carsFind);
        }

        return modelAndView;
    }



}
