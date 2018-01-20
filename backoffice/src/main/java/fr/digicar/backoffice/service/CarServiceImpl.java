package fr.digicar.backoffice.service;

/**
 * Created by barry on 31/12/2017.
 */

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
    public Car getCar(String registration_number) {
        return carDAO.getCar(registration_number);
    }

    @Transactional
    public void deleteCar(int carId) {
        carDAO.deleteCar(carId);
    }

    @Transactional
    public List<Car> getAllCar() {
        return carDAO.getCars();
    }

}
