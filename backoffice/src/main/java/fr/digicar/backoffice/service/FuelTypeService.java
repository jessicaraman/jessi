package fr.digicar.backoffice.service;

import fr.digicar.model.FuelType;

import java.util.List;

/**
 * Created by barry on 31/12/2017.
 */
public interface FuelTypeService {
    void addFuelType(FuelType fuelType);
    List<FuelType> getAllFuelType();
}
