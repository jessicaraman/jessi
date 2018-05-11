package fr.digicar.backoffice.service;

import fr.digicar.model.Car;
import fr.digicar.model.CarAvailability;

import java.util.List;

public interface CarAvailabilityService {

    CarAvailability getCarAvailabilityByCriteria(String available);

    List<Car> getCarAvailabilityBy(String location, int idCarType);

    //Utiliser pour le 2ième algo
    // List<CarAvailability> getCarAvailabilityBy(String starDate, String endDate, String location, int idCarType);

    List<CarAvailability> getAllCarAvailabilities();
}
