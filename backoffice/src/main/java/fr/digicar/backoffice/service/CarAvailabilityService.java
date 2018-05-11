package fr.digicar.backoffice.service;

import fr.digicar.model.Car;
import fr.digicar.model.CarAvailability;
import fr.digicar.odt.FilterBookingOdt;
import fr.digicar.odt.ReservationOdt;

import java.util.List;

public interface CarAvailabilityService {

    CarAvailability getCarAvailabilityByCriteria(String available);

    List<ReservationOdt> getCarAvailabilityBy(final FilterBookingOdt filters);

    //Utiliser pour le 2ième algo
    // List<CarAvailability> getCarAvailabilityBy(String starDate, String endDate, String location, int idCarType);

    List<CarAvailability> getAllCarAvailabilities();
}
