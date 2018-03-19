package fr.digicar.backoffice.service;

import fr.digicar.model.Availability;

import java.util.List;

public interface AvailabilityService {

    Availability getAvailabilityById(int id_availability);
    List<Availability> getAllAvailability();
    List<Availability> availabilityByCreteria(String date, String start_time, String end_time);

}
