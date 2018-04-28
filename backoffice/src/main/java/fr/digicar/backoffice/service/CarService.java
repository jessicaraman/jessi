package fr.digicar.backoffice.service;

import fr.digicar.model.Car;

import java.util.List;

public interface CarService {

    void addCar(Car car);

    void updateCar(Car car);

    Car getCarById(int carId);

    Car getCarByRegistration(String registration);

    void deleteCar(int carId);

    List<Car> getAllCar();

    List<Car> CarByCriteria(String mark, String modelName, String type, String transmission, String fuelType, String mileageMin, String mileageMax);

}
