package fr.digicar.dao;

import fr.digicar.model.FuelType;

import java.util.List;

public interface FuelTypeDAO {

    void addFuelType(FuelType fuelType);

    List<FuelType> getAllFuelType();

}
