package fr.digicar.backoffice.service;

import fr.digicar.dao.ParkingDAO;
import fr.digicar.model.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService{

    @Autowired
    private ParkingDAO parkingDAO;

    @Override
    public Parking getParkingById(int id) {
        return parkingDAO.getParkingById(id);    }

    @Override
    public List<Parking> getAllParkings() {
        return parkingDAO.getAllParkings();
    }
}
