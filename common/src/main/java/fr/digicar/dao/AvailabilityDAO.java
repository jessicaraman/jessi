package fr.digicar.dao;

import fr.digicar.model.Availability;
import java.util.List;

public interface AvailabilityDAO {

    Availability getAvailabilityById(int availabilityId);
    List<Availability> availabilityByCriteria(String date, String start_time, String end_time);
    List<Availability> getAllAvailability();

}
