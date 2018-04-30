package fr.digicar.dao;

import fr.digicar.model.Car;
import org.hibernate.JDBCException;

import java.util.List;

public interface CarDAO {

    void addCar(Car car);

    void updateCar(Car car) throws JDBCException;

    Car getCarById(int carId);

    Car getCarByRegistration(String registration);

    void deleteCar(int carId);

    List<Car> carByCriteria(String brandName, String modelName, String type, String transmission, String fuelType, String mileageMin, String mileageMax);

    List<Car> getAllCar();

}
