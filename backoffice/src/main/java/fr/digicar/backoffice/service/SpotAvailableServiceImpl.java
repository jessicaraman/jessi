package fr.digicar.backoffice.service;

import fr.digicar.dao.SpotAvailableDAO;
import fr.digicar.model.SpotAvailable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SpotAvailableServiceImpl implements SpotAvailableService{

    @Autowired
    private SpotAvailableDAO spotAvailableDAO;

    @Transactional
    public void updateSpotAvailable(SpotAvailable spotAvailable) {
        spotAvailableDAO.updateSpotAvailable(spotAvailable);
    }

    @Transactional
    public SpotAvailable getSpotAvailableById(int id_parking_spots) {
        return spotAvailableDAO.getSpotAvailableById(id_parking_spots);
    }

    @Transactional
    public List<SpotAvailable> getAllSpotsAvailable() {
        return spotAvailableDAO.getAllSpotsAvailable();
    }
}
