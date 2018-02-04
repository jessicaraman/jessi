package fr.digicar.dao;

import fr.digicar.model.CarType;

import java.util.List;

public interface CarTypeDAO {

    void addCarType(CarType carType);
    List<CarType> getAllCarType();

}
