package fr.digicar.backoffice.service;

import fr.digicar.model.Car;

import java.util.List;

/**
 * Created by barry on 31/12/2017.
 */
public interface CarService {
    void addCar(Car car);
    void updateCar(Car car);
    Car getCarById(int carId);
    Car getCarByRegistration(String registration);
    void deleteCar(int carId);
    List<Car> getAllCar();
    List<Car> CarByCriteria(String mark, String name_model, String type, String transmission, String fuel_type, String mileageMin, String mileageMax);
}
