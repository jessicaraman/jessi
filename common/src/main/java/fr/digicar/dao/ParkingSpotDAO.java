package fr.digicar.dao;

import fr.digicar.model.ParkingSpot;

import java.util.List;

public interface ParkingSpotDAO {

    void addParkingSpot(ParkingSpot parkingSpot);
    void updateParkingSpot(ParkingSpot parkingSpot);
    ParkingSpot getParkingSpot(int id);
    void deleteParkingSpot(int id);
    List<ParkingSpot> getParkingSpots();

}
