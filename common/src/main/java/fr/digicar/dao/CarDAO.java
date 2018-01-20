package fr.digicar.dao;

import fr.digicar.model.Car;

import java.util.List;

public interface CarDAO {

    void addCar(Car car);
    void updateCar(Car car);
    Car getCar(int carId);
    void deleteCar(int carId);
    List<Car> getCars();

}
