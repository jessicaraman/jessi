package fr.digicar.backoffice.service;

import fr.digicar.model.Car;
import fr.digicar.model.CarAvailability;
import fr.digicar.odt.FilterBookingOdt;
import fr.digicar.odt.ReservationOdt;

import java.util.List;

public interface CarAvailabilityService {

    CarAvailability getCarAvailabilityByCriteria(String available);

    List<ReservationOdt> getCarAvailabilityBy(final FilterBookingOdt filters);

    void updateCarAvailabilityId(int idCar, String state);

    List<CarAvailability> getAllCarAvailabilities();
}
