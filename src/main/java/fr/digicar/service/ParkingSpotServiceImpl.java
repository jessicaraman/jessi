package fr.digicar.service;

import java.util.List;

import fr.digicar.dao.ParkingSpotDAO;
import fr.digicar.model.ParkingSpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ParkingSpotServiceImpl implements ParkingSpotService {

    @Autowired
    private ParkingSpotDAO parkingSpotDAO;

    public void addParkingSpot(ParkingSpot parkingSpot) {
        parkingSpotDAO.addParkingSpot(parkingSpot);
    }

    /*public void updateParkingSpot(ParkingSpot parkingSpot) {
        parkingSpotDAO.updateParkingSpot(parkingSpot);
    }

    public ParkingSpot getParkingSpot(int id) {
        return parkingSpotDAO.getParkingSpot(id);
    }

    public void deleteParkingSpot(int id) {
        parkingSpotDAO.deleteParkingSpot(id);
    }
*/
    public List<ParkingSpot> getParkingSpots() {
        return parkingSpotDAO.getParkingSpots();
    }

}
