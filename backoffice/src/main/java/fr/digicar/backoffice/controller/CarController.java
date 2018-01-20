package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.CarService;
import fr.digicar.backoffice.service.CarTypeService;
import fr.digicar.backoffice.service.FuelTypeService;
import fr.digicar.backoffice.service.TransmissionModeService;
import fr.digicar.model.Car;
import fr.digicar.model.CarType;
import fr.digicar.model.FuelType;
import fr.digicar.model.TransmissionMode;
import fr.digicar.odt.FilterOdt;
import fr.digicar.odt.FilterRegistrationIdOdt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/car")
public class CarController {

    //TODO Gestion exception

    @Autowired
    private CarService carService;

    @Autowired
    private CarTypeService carTypeService;

    @Autowired
    private TransmissionModeService transmissionModeService;

    @Autowired
    private FuelTypeService fuelTypeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getViewForListCar() {
        ModelAndView modelAndView = new ModelAndView("car/home-car-referential");
        modelAndView.addObject("filteregistration", new FilterRegistrationIdOdt());
        modelAndView.addObject("filters", new FilterOdt());
        modelAndView.addObject("car", new Car());
        List<Car> cars = carService.getAllCar();
        modelAndView.addObject("cars", cars);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView getViewForaddCar() {

        ModelAndView modelAndView = new ModelAndView("car/add-car-form");

        List<CarType> listOfCarType = carTypeService.getAllCarType();
        List<TransmissionMode> listOfTransmissionMode = transmissionModeService.getAllTransmissionMode();
        List<FuelType> listOfFuelType = fuelTypeService.getAllFuelType();

        modelAndView.addObject("car", new Car());
        modelAndView.addObject("listOfCarType", listOfCarType);
        modelAndView.addObject("listOfTransmissionMode", listOfTransmissionMode);
        modelAndView.addObject("listOfFuelType", listOfFuelType);

        return modelAndView;
    }

    @RequestMapping(value = "/adding", method = RequestMethod.POST)
    public ModelAndView addingCar(@ModelAttribute("car") Car car, BindingResult result) {
        carService.addCar(car);
        
        ModelAndView modelAndView = new ModelAndView("car/home-car-referential");

        /*Car addedCar = car;

        modelAndView.addObject("addedCar", addedCar);*/

        String confirmationmessage;

        confirmationmessage = "Le véhicule"+car.getRegistration_number()+" a bien été ajouté";
        modelAndView.addObject("confirmationmessage", confirmationmessage);
        modelAndView.addObject("filteregistration", new FilterRegistrationIdOdt());
        modelAndView.addObject("filters", new FilterOdt());

        List<Car> cars = carService.getAllCar();
        modelAndView.addObject("cars", cars);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteCar/{registration_number}/{carId}", method = RequestMethod.GET)
    public ModelAndView deleteCar(@PathVariable int carId, @PathVariable String registration_number) {
        carService.deleteCar(carId);

        ModelAndView modelAndView = new ModelAndView("car/home-car-referential");

        String message;

        message = "Le véhicule"+registration_number+" a bien été supprimé";
        modelAndView.addObject("message", message);
        modelAndView.addObject("filteregistration", new FilterRegistrationIdOdt());
        modelAndView.addObject("filters", new FilterOdt());

        return modelAndView;
    }
    @RequestMapping(value = "/updateCar/{registration_number}", method = RequestMethod.GET)
    public ModelAndView getViewForUpdateCar(@PathVariable String registration_number) {
        List<Car> cars = carService.getAllCar();

        Car car = new Car();
        String registration;
        for (int i=0; i<cars.size(); i++){
            car = cars.get(i);
            registration = car.getRegistration_number();
            if(registration_number.equals(registration)){
                break;
            }
        }
        List<CarType> listOfCarType = carTypeService.getAllCarType();
        List<TransmissionMode> listOfTransmissionMode = transmissionModeService.getAllTransmissionMode();
        List<FuelType> listOfFuelType = fuelTypeService.getAllFuelType();

        ModelAndView modelAndView = new ModelAndView("car/update-car");
        modelAndView.addObject("car", car);
        modelAndView.addObject("listOfCarType", listOfCarType);
        modelAndView.addObject("listOfTransmissionMode", listOfTransmissionMode);
        modelAndView.addObject("listOfFuelType", listOfFuelType);

        return modelAndView;
    }

    @RequestMapping(value = "/uptodate", method = RequestMethod.POST)
    public ModelAndView updateCar(@ModelAttribute("car") Car car) {
        ModelAndView modelAndView = new ModelAndView("car/home-car-referential");
        String confirmationmessage;

        carService.updateCar(car);
        confirmationmessage = "Le véhicule"+car.getRegistration_number()+" a bien été mis à jour";
        modelAndView.addObject("confirmationmessage", confirmationmessage);
        modelAndView.addObject("filteregistration", new FilterRegistrationIdOdt());
        modelAndView.addObject("filters", new FilterOdt());

        List<Car> cars = carService.getAllCar();
        modelAndView.addObject("cars", cars);

        return modelAndView;
    }

    @RequestMapping(value = "/registrationId", method = RequestMethod.POST)
    public ModelAndView getCarByRegistrationId(@ModelAttribute("filteregistration") final FilterRegistrationIdOdt filterRegistrationIdOdt) {
        String registration = filterRegistrationIdOdt.getregistrationNumber();
        String message;

        List<Car> cars = carService.getAllCar();

        Car car = new Car();
        Boolean check = false;
        String registrationId;
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
        List<Car> allCars = carService.getAllCar();
        String message;

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
