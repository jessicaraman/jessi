package fr.digicar.dao;

import fr.digicar.model.CarAvailability;

import java.util.List;

public interface CarAvailabilityDAO {

    CarAvailability getCarAvailabilityByCriteria(String available);

    List<CarAvailability> getAllCarAvailabilities();
}



