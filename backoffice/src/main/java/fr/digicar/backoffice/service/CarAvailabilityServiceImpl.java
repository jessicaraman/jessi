package fr.digicar.backoffice.service;

import fr.digicar.dao.*;
import fr.digicar.model.Car;
import fr.digicar.model.CarAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarAvailabilityServiceImpl implements CarAvailabilityService{

    @Autowired
    private CarAvailabilityDAO carAvailabilityDAO;

    @Autowired
    private ParkingSpotDAO parkingSpotDAO;

    @Autowired
    private CarTypeDAO carTypeDAO;

    @Autowired
    private CarDAO carDAO;

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

    @Override
    public List<Car> getCarAvailabilityBy(String location, int idCarType){
        List<CarAvailability> listOfCarAvailable = carAvailabilityDAO.getAllCarAvailabilities();

        List<CarAvailability> carsAvailableWithCriteria = new ArrayList();

        List<Car> cars = new ArrayList();

        for (CarAvailability carAvailable : listOfCarAvailable){
            if (carDAO.getCarById(carAvailable.getId_car()).getType() != idCarType
                    || !(parkingSpotDAO.getParkingSpot(carAvailable.getId_parking_spots()).getLocation().equals(location)) ) {
                carsAvailableWithCriteria.add(carAvailable);
            }
        }

        for( CarAvailability carAvailableWithCriteria : carsAvailableWithCriteria){
            cars.add(carDAO.getCarById(carAvailableWithCriteria.getId_car()));
        }

        return  cars;
    }

}
