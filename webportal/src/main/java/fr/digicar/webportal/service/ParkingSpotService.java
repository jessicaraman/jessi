package fr.digicar.webportal.service;

import fr.digicar.model.ParkingSpot;

import java.util.List;

public interface ParkingSpotService {

    void addParkingSpot(ParkingSpot parkingSpot);

    void updateParkingSpot(ParkingSpot parkingSpot);

    ParkingSpot getParkingSpot(int id);

    void deleteParkingSpot(int id);

    List<ParkingSpot> getParkingSpots();
    List<ParkingSpot> getParkingSpotByObj(ParkingSpot p);

}
