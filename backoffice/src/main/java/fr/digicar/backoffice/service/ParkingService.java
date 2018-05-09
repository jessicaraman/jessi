package fr.digicar.backoffice.service;

import fr.digicar.model.Parking;

import java.util.List;

public interface ParkingService {

    Parking getParkingById(int id);

    List<Parking> getAllParkings();

}
