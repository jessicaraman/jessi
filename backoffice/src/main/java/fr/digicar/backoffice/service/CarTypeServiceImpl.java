package fr.digicar.backoffice.service;

/**
 * Created by barry on 31/12/2017.
 */

import fr.digicar.dao.CarTypeDAO;
import fr.digicar.model.CarType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarTypeServiceImpl implements CarTypeService {

    @Autowired
    private CarTypeDAO carTypeDAO;

    @Override
    public void addCarType(CarType carType) {
        carTypeDAO.addCarType(carType);
    }

    @Override
    public List<CarType> getAllCarType() {
        return carTypeDAO.getAllCarType();
    }

}
