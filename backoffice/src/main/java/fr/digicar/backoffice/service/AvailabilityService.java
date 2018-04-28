package fr.digicar.backoffice.service;

import fr.digicar.model.Availability;

import java.util.List;

public interface AvailabilityService {

    Availability getAvailabilityById(int idAvailability);
    
    List<Availability> getAllAvailability();
    
    List<Availability> availabilityByCriteria(String date, String startTime, String endTime);
    
}
