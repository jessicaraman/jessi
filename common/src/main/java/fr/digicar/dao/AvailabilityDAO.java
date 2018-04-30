package fr.digicar.dao;

import fr.digicar.model.Availability;

import java.util.List;

public interface AvailabilityDAO {

    Availability getAvailabilityById(int availabilityId);

    List<Availability> availabilityByCriteria(String date, String startTime, String endTime);

    List<Availability> getAllAvailability();

}
