package fr.digicar.dao;

import fr.digicar.model.CarAvailability;

import java.util.List;

public interface CarAvailabilityDAO {

    CarAvailability getCarAvailabilityByCriteria(String available);

    List<CarAvailability> getCarAvailabilityBy(String location, int idCarType);

    //Algo 2
    // List<CarAvailability> getCarAvailabilityBy(String starDate, String endDate, int location, String carType);

    List<CarAvailability> getAllCarAvailabilities();
}



