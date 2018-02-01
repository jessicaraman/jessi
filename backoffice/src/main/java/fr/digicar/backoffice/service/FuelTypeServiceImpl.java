package fr.digicar.backoffice.service;

/**
 * Created by barry on 31/12/2017.
 */

import fr.digicar.dao.FuelTypeDAO;
import fr.digicar.model.FuelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FuelTypeServiceImpl implements FuelTypeService {

    @Autowired
    private FuelTypeDAO fuelTypeDAO;

    @Override
    public void addFuelType(FuelType fuelType) {
        fuelTypeDAO.addFuelType(fuelType);
    }

    @Override
    public List<FuelType> getAllFuelType() {
        return fuelTypeDAO.getAllFuelType();
    }

}
