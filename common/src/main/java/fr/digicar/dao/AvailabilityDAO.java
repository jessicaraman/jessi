package fr.digicar.dao;

import fr.digicar.model.Availability;
import fr.digicar.model.Car;

import java.time.LocalTime;
import java.util.List;

public interface AvailabilityDAO {

    Availability getAvailabilityById(int availabilityId);
    List<Availability> availabilityByCriteria(String date, LocalTime start_time, LocalTime end_time);
    List<Availability> getAllAvailability();

}
