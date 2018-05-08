package fr.digicar.backoffice.service;

import fr.digicar.dao.CarAvailabilityDAO;
import fr.digicar.model.CarAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CarAvailabilityServiceImpl {

    @Autowired
    private CarAvailabilityDAO carAvailabilityDAO;

    @Transactional
    public CarAvailability getCarAvailabilityByCriteria(String available) {
        return carAvailabilityDAO.getCarAvailabilityByCriteria(available);
    }

    @Transactional
    public List<CarAvailability> getAllCarAvailabilities() {
        return carAvailabilityDAO.getAllCarAvailabilities();
    }
}
