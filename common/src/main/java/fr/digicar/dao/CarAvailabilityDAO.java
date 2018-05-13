package fr.digicar.dao;

import fr.digicar.model.CarAvailability;

import java.util.List;

public interface CarAvailabilityDAO {

    CarAvailability getCarAvailabilityByCriteria(String available);

    List<CarAvailability> getCarAvailabilityBy(String location, int idCarType);

    List<CarAvailability> getAllCarAvailabilities();

    void updateCarAvailabilityId(int idCar, String state);
}



