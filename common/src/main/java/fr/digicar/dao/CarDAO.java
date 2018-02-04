package fr.digicar.dao;

import fr.digicar.model.Car;

import java.util.List;

public interface CarDAO {

    void addCar(Car car);
    void updateCar(Car car);
    Car getCarById(int carId);
    Car getCarByRegistration(String registration);
    void deleteCar(int carId);
    List<Car> getCars();
    List<Car> CarByCriteria(String mark, String name_model, String type, String transmission, String fuel_type, String mileageMin, String mileageMax);

}
