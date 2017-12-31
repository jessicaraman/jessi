package fr.digicar.backoffice.service;

import fr.digicar.dao.ParkingSpotDAO;
import fr.digicar.model.ParkingSpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class ParkingSpotServiceImpl implements ParkingSpotService {

    @Autowired
    private ParkingSpotDAO parkingSpotDAO;

    @Override
    public void addParkingSpot(ParkingSpot parkingSpot) {
        parkingSpotDAO.addParkingSpot(parkingSpot);
    }


    @Override
    public void updateParkingSpot(ParkingSpot parkingSpot) {
        parkingSpotDAO.updateParkingSpot(parkingSpot);
    }

    @Override
    public ParkingSpot getParkingSpot(int id) {
        return parkingSpotDAO.getParkingSpot(id);
    }

    @Override
    public void deleteParkingSpot(int id) {
        parkingSpotDAO.deleteParkingSpot(id);
    }


    @Override
    public List<ParkingSpot> getParkingSpots() {
        return parkingSpotDAO.getParkingSpots();
    }

}
