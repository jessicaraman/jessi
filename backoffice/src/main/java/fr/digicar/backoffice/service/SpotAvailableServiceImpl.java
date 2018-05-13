package fr.digicar.backoffice.service;

import fr.digicar.dao.ParkingSpotDAO;
import fr.digicar.dao.SpotAvailableDAO;
import fr.digicar.model.ParkingSpot;
import fr.digicar.model.SpotAvailable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SpotAvailableServiceImpl implements SpotAvailableService{

    @Autowired
    private SpotAvailableDAO spotAvailableDAO;

    @Autowired
    private ParkingSpotDAO parkingSpotDAO;

    @Override
    public void updateSpotAvailable(SpotAvailable spotAvailable) {
        spotAvailableDAO.updateSpotAvailable(spotAvailable);
    }

    @Override
    public SpotAvailable getSpotAvailableById(int id_parking_spots) {
        return spotAvailableDAO.getSpotAvailableById(id_parking_spots);
    }

    @Override
    public ParkingSpot getSpotAvailableByIdLocation(String location) {
        List<SpotAvailable> spotAvailables = spotAvailableDAO.getAllSpotsAvailable();

        ParkingSpot parkingSpotOfCity = new ParkingSpot();

        List<ParkingSpot> parkingSpots = parkingSpotDAO.getParkingSpotIdFrom(location);

        for(ParkingSpot parkingSpot: parkingSpots){
            for(SpotAvailable spotAvailable: spotAvailables){
                if(Integer.parseInt(parkingSpot.getNbParking()) == spotAvailable.getId_parking_spots()){
                    parkingSpotOfCity = parkingSpot;
                }
            }
        }
        return  parkingSpotOfCity;
    }

    @Override
    public List<SpotAvailable> getAllSpotsAvailable() {
        return spotAvailableDAO.getAllSpotsAvailable();
    }
}
