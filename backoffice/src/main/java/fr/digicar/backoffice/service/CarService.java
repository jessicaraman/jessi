package fr.digicar.backoffice.service;

import fr.digicar.model.Car;

import java.util.List;

/**
 * Created by barry on 31/12/2017.
 */
public interface CarService {
    void addCar(Car car);
    void updateCar(Car car);
    Car getCar(String registration_number);
    void deleteCar(int carId);
    List<Car> getAllCar();
}
