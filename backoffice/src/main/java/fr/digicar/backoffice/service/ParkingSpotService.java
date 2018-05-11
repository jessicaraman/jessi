package fr.digicar.backoffice.service;

import fr.digicar.model.ParkingSpot;

import java.util.List;
import java.util.Set;

public interface ParkingSpotService {

    String getLocationById(int id);

    int getIdByLocation(String location);

    Set<String> getListOfLocation();

    void addParkingSpot(ParkingSpot parkingSpot);

    void updateParkingSpot(ParkingSpot parkingSpot);

    ParkingSpot getParkingSpot(int id);

    void deleteParkingSpot(int id);

    List<ParkingSpot> getParkingSpots();

    List<ParkingSpot> getParkingSpotByObj(ParkingSpot p);

}
