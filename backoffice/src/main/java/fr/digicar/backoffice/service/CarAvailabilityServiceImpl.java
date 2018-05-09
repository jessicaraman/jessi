package fr.digicar.backoffice.service;

import fr.digicar.dao.CarAvailabilityDAO;
import fr.digicar.model.CarAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CarAvailabilityServiceImpl implements CarAvailabilityService{

    @Autowired
    private CarAvailabilityDAO carAvailabilityDAO;

    @Transactional
    @Override
    public CarAvailability getCarAvailabilityByCriteria(String available) {
        return carAvailabilityDAO.getCarAvailabilityByCriteria(available);
    }

    @Transactional
    @Override
    public List<CarAvailability> getAllCarAvailabilities() {
        return carAvailabilityDAO.getAllCarAvailabilities();
    }
}
