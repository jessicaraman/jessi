package fr.digicar.backoffice.service;

import fr.digicar.model.CarType;

import java.util.List;

/**
 * Created by barry on 31/12/2017.
 */
public interface CarTypeService {
    void addCarType(CarType carType);
    List<CarType> getAllCarType();
}
