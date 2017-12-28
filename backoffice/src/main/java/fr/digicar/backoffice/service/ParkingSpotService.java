package fr.digicar.service;

import java.util.List;

import fr.digicar.model.ParkingSpot;

public interface ParkingSpotService {

    public void addParkingSpot(ParkingSpot parkingSpot);
    public void updateParkingSpot(ParkingSpot parkingSpot);
    public ParkingSpot getParkingSpot(int id);
    public void deleteParkingSpot(int id);
    public List<ParkingSpot> getParkingSpots();

}
