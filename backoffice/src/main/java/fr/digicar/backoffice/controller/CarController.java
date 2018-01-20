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

        modelAndView.addObject("listOfCarType", carTypeService.getAllCarType());
        modelAndView.addObject("listOfTransmissionMode", transmissionModeService.getAllTransmissionMode());
        modelAndView.addObject("listOfFuelType", fuelTypeService.getAllFuelType());

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

        modelAndView.addObject("car", new Car());
        modelAndView.addObject("listOfCarType", carTypeService.getAllCarType());
        modelAndView.addObject("listOfTransmissionMode", transmissionModeService.getAllTransmissionMode());
        modelAndView.addObject("listOfFuelType", fuelTypeService.getAllFuelType());

        return modelAndView;
    }

    @RequestMapping(value = "/adding", method = RequestMethod.POST)
    public ModelAndView addingCar(@ModelAttribute("car") Car car, BindingResult result) {
        List<Car> cars = carService.getAllCar();
        ModelAndView modelAndView = new ModelAndView("car/home-car-referential");
        String confirmationMessage;
        String alertMessage;

        Boolean checked = false;
        String actual;
        String expected = car.getRegistration_number();
        for (int i=0; i<cars.size(); i++){
            actual = cars.get(i).getRegistration_number();
            if(actual.equals(expected)){
                checked= true;
                break;
            }
        }
        if (checked){

            alertMessage = "Cette immatriculation est connue dans le référentiel ! ";
            modelAndView.addObject("alertMessage", alertMessage);

        }
        else{
            carService.addCar(car);
            confirmationMessage = "Le véhicule "+car.getRegistration_number()+" a bien été ajouté";
            modelAndView.addObject("confirmationMessage", confirmationMessage);

        }

        modelAndView.addObject("filteregistration", new FilterRegistrationIdOdt());
        modelAndView.addObject("filters", new FilterOdt());
        modelAndView.addObject("listOfCarType", carTypeService.getAllCarType());
        modelAndView.addObject("listOfTransmissionMode", transmissionModeService.getAllTransmissionMode());
        modelAndView.addObject("listOfFuelType", fuelTypeService.getAllFuelType());

        List<Car> actualCar = carService.getAllCar();
        modelAndView.addObject("cars", actualCar);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteCar/{registration_number}/{carId}", method = RequestMethod.GET)
    public ModelAndView deleteCar(@PathVariable int carId, @PathVariable String registration_number) {
        carService.deleteCar(carId);
        ModelAndView modelAndView = new ModelAndView("car/home-car-referential");
        String message;

        message = "Le véhicule "+registration_number+" a bien été supprimé";
        modelAndView.addObject("message", message);
        modelAndView.addObject("filteregistration", new FilterRegistrationIdOdt());
        modelAndView.addObject("filters", new FilterOdt());
        List<Car> cars = carService.getAllCar();
        modelAndView.addObject("cars", cars);

        return modelAndView;
    }
    @RequestMapping(value = "/updateCar/{carId}", method = RequestMethod.GET)
    public ModelAndView getViewForUpdateCar(@PathVariable int carId) {
        Car car = carService.getCar(carId);

        ModelAndView modelAndView = new ModelAndView("car/update-car");
        modelAndView.addObject("car", car);
        modelAndView.addObject("listOfCarType", carTypeService.getAllCarType());
        modelAndView.addObject("listOfTransmissionMode", transmissionModeService.getAllTransmissionMode());
        modelAndView.addObject("listOfFuelType", fuelTypeService.getAllFuelType());

        return modelAndView;
    }

    @RequestMapping(value = "/updating", method = RequestMethod.POST)
    public ModelAndView updateCar(@ModelAttribute("car") Car car) {
        ModelAndView modelAndView = new ModelAndView("car/home-car-referential");
        String confirmationmessage;

        carService.updateCar(car);
        confirmationmessage = "Le véhicule "+car.getRegistration_number()+" a bien été mis à jour";
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
                //TODO Gérer les autres filtres renseignés
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
