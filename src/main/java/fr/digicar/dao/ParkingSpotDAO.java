package fr.digicar.dao;

import fr.digicar.model.ParkingSpot;

import java.util.List;

public interface ParkingSpotDAO {

    public void addParkingSpot(ParkingSpot parkingSpot);
    public void updateParkingSpot(ParkingSpot parkingSpot);
    public ParkingSpot getParkingSpot(int id);
    public void deleteParkingSpot(int id);
    public List<ParkingSpot> getParkingSpots();

}
