package fr.digicar.dao;

import fr.digicar.model.CarAvailability;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public interface CarAvailabilityDAO {

    CarAvailability getCarAvailabilityByCriteria(String available);

    List<CarAvailability> getAllCarAvailabilities();
}



