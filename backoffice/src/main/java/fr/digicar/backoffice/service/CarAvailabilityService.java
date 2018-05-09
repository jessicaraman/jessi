package fr.digicar.backoffice.service;

import fr.digicar.model.CarAvailability;

import java.util.List;

public interface CarAvailabilityService {

    CarAvailability getCarAvailabilityByCriteria(String available);

    List<CarAvailability> getAllCarAvailabilities();
}
