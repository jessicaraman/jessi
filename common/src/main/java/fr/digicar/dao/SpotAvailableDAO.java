package fr.digicar.dao;

import fr.digicar.model.SpotAvailable;
import org.hibernate.JDBCException;

import java.util.List;

public interface SpotAvailableDAO {

    void updateSpotAvailable(SpotAvailable spotAvailable) throws JDBCException;

    SpotAvailable getSpotAvailableById(int id_parking_spots);

    List<SpotAvailable> getAllSpotsAvailable();

}
