package fr.digicar.dao;

import fr.digicar.model.Parking;

import java.util.List;

public interface ParkingDAO {

    Parking getParkingById(int id);

    List<Parking> getAllParkings();

}
