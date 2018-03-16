package fr.digicar.webportal.service;

import fr.digicar.model.Availability;

import java.util.List;
import java.time.LocalTime;

public interface AvailabilityService {

    Availability getAvailabilityById(int id_availability);
    List<Availability> getAllAvailability();
    List<Availability> availabilityByCreteria(String date, LocalTime start_time, LocalTime end_time);

}
