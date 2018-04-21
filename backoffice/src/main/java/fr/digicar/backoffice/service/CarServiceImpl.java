package fr.digicar.backoffice.service;

import fr.digicar.dao.CarDAO;
import fr.digicar.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("countryService")
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDAO carDAO;

    @Transactional
    public void addCar(Car car) {
        carDAO.addCar(car);
    }

    @Transactional
    public void updateCar(Car car) {
        carDAO.updateCar(car);
    }

    @Transactional
    public Car getCarById(int carId) {
        return carDAO.getCarById(carId);
    }

    @Transactional
    public Car getCarByRegistration(String registration) {
        return carDAO.getCarByRegistration(registration);
    }

    @Transactional
    public void deleteCar(int carId) {
        carDAO.deleteCar(carId);
    }

    @Transactional
    public List<Car> getAllCar() {
        return carDAO.getAllCar();
    }

    @Transactional
    public List<Car> CarByCriteria(String mark, String modelName, String type, String transmission, String fuelType, String mileageMin, String mileageMax) {
        return carDAO.carByCriteria(mark, modelName, type, transmission, fuelType, mileageMin, mileageMax);
    }


}
