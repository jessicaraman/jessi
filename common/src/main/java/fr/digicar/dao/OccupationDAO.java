package fr.digicar.dao;

import fr.digicar.model.Availability;
import fr.digicar.model.Occupation;

import java.util.List;


public interface OccupationDAO {

    Occupation getOccupationById(int id_occupation);
    List<Occupation> getAllOccupations();
}
