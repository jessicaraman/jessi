package fr.digicar.backoffice.service;

import fr.digicar.dao.ParkingSpotDAO;
import fr.digicar.model.ParkingSpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    @Override
    public List<ParkingSpot> getParkingSpotByObj(ParkingSpot p) {
        return parkingSpotDAO.getParkingSpotByObj(p);
    }

    @Override
    public String getLocationById(int id){
        String location = new String();
        List<ParkingSpot> listOfParkingSpot = parkingSpotDAO.getParkingSpots();
        for (ParkingSpot parkingSpot : listOfParkingSpot){
            if (parkingSpot.getId() == id){
                location = parkingSpot.getLocation();
                break;
            }
        }
        return location;
    }

    @Override
    public int getIdByLocation(String location){
        int id = -1;
        List<ParkingSpot> listOfParkingSpot = parkingSpotDAO.getParkingSpots();
        for (ParkingSpot parkingSpot : listOfParkingSpot){
            if (parkingSpot.getLocation().equals(location)){
                id = parkingSpot.getId();
                break;
            }
        }
        return id;
    }

    @Override
    public Set<String> getListOfLocation(){
        List<String> listOfLocation = new ArrayList<>();
        List<ParkingSpot> listOfParkingSpot = parkingSpotDAO.getParkingSpots();
        for(ParkingSpot parkingSpot : listOfParkingSpot)
            listOfLocation.add(parkingSpot.getLocation());
        return new TreeSet<>(listOfLocation);
    }

}
