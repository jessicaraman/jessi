package fr.digicar.dao;

import fr.digicar.model.Car;

import java.util.List;

public interface CarDAO {

    void addCar(Car car);
    void updateCar(Car car);
    Car getCar(String registration_number);
    void deleteCar(String registration_number);
    List<Car> getCars();

}
