package fr.digicar.backoffice.service;

import java.util.List;

import fr.digicar.model.ParkingSpot;

public interface ParkingSpotService {

    void addParkingSpot(ParkingSpot parkingSpot);

    void updateParkingSpot(ParkingSpot parkingSpot);

    ParkingSpot getParkingSpot(int id);

    void deleteParkingSpot(int id);

    List<ParkingSpot> getParkingSpots();
    List<ParkingSpot> getParkingSpotByObj(ParkingSpot p);

}
