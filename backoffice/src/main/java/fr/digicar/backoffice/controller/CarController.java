package fr.digicar.backoffice.controller;

import fr.digicar.backoffice.service.CarService;
import fr.digicar.backoffice.service.CarTypeService;
import fr.digicar.backoffice.service.FuelTypeService;
import fr.digicar.backoffice.service.TransmissionModeService;
import fr.digicar.model.Car;
import fr.digicar.odt.FilterOdt;
import fr.digicar.odt.FilterRegistrationIdOdt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
        String expected = car.getRegistrationNumber();
        for (Car car1 : cars) {
            actual = car1.getRegistrationNumber();
            if (actual.equals(expected)) {
                checked = true;
                break;
            }
        }
        if (checked) {

            alertMessage = "Cette immatriculation est connue dans le référentiel ! ";
            modelAndView.addObject("alertMessage", alertMessage);

        } else {
            carService.addCar(car);
            confirmationMessage = "Le véhicule " + car.getRegistrationNumber() + " a bien été ajouté";
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

        message = "Le véhicule " + registration_number + " a bien été supprimé";
        modelAndView.addObject("message", message);
        modelAndView.addObject("filteregistration", new FilterRegistrationIdOdt());
        modelAndView.addObject("filters", new FilterOdt());
        List<Car> cars = carService.getAllCar();
        modelAndView.addObject("cars", cars);

        return modelAndView;
    }

    @RequestMapping(value = "/updateCar/{carId}", method = RequestMethod.GET)
    public ModelAndView getViewForUpdateCar(@PathVariable int carId) {
        Car car = carService.getCarById(carId);

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
        String confirmationMessage;

        carService.updateCar(car);
        confirmationMessage = "Le véhicule " + car.getRegistrationNumber() + " a bien été mis à jour";
        modelAndView.addObject("confirmationMessage", confirmationMessage);
        modelAndView.addObject("filteregistration", new FilterRegistrationIdOdt());
        modelAndView.addObject("filters", new FilterOdt());

        modelAndView.addObject("listOfCarType", carTypeService.getAllCarType());
        modelAndView.addObject("listOfTransmissionMode", transmissionModeService.getAllTransmissionMode());
        modelAndView.addObject("listOfFuelType", fuelTypeService.getAllFuelType());

        List<Car> cars = carService.getAllCar();
        modelAndView.addObject("cars", cars);

        return modelAndView;
    }

    @RequestMapping(value = "/registrationId", method = RequestMethod.POST)
    public ModelAndView findCarByCriteriaNominalCase(@ModelAttribute("filteregistration") final FilterRegistrationIdOdt filterRegistrationIdOdt) {
        String registration = filterRegistrationIdOdt.getRegistrationNumber();
        String message;

        Car cardfiltered = carService.getCarByRegistration(registration);

        ModelAndView modelAndView = new ModelAndView("car/home-car-referential");
        modelAndView.addObject("car", new Car());
        modelAndView.addObject("filters", new FilterOdt());
        modelAndView.addObject("listOfCarType", carTypeService.getAllCarType());

        if (null == cardfiltered) {
            message = "Veuillez Renseigner un matricule correcte ou utiliser la recherche générale";
            modelAndView.addObject("message", message);
        } else {
            List<Car> carFilter = new ArrayList<>();
            carFilter.add(cardfiltered);
            modelAndView.addObject("cars", carFilter);
        }
        return modelAndView;

    }

    @RequestMapping(value = "/allcars", method = RequestMethod.POST)
    public ModelAndView findCarByCriteria(@ModelAttribute("filters") final FilterOdt filterOdt) {
        String carBrand = filterOdt.getCarBrand();
        String modelName = filterOdt.getModelName();
        String typeCar = filterOdt.getTypeCar();
        String transmission = filterOdt.getTransmission();
        String fuelType = filterOdt.getFuelType();

        String mileageMin = filterOdt.getMileageMin();
        String mileageMax = filterOdt.getMileageMax();

        List<Car> allCarList = carService.CarByCriteria(carBrand, modelName, typeCar, transmission, fuelType, mileageMin, mileageMax);

        String message;
        List<Car> cars = new ArrayList<>();

        ModelAndView modelAndView = new ModelAndView("car/home-car-referential");

        modelAndView.addObject("listOfCarType", carTypeService.getAllCarType());
        modelAndView.addObject("listOfTransmissionMode", transmissionModeService.getAllTransmissionMode());
        modelAndView.addObject("listOfFuelType", fuelTypeService.getAllFuelType());

        modelAndView.addObject("car", new Car());
        modelAndView.addObject("filters", new FilterOdt());
        modelAndView.addObject("filteregistration", new FilterRegistrationIdOdt());

        if (allCarList.isEmpty()) {
            message = "Aucun véhicule trouvé pour cette rechercher";
            modelAndView.addObject("message", message);
            modelAndView.addObject("cars", cars);
        } else {
            modelAndView.addObject("cars", allCarList);
        }

        return modelAndView;
    }


}
