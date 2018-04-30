package fr.digicar.dao;

import fr.digicar.model.Occupation;

import java.util.List;

public interface OccupationDAO {

    Occupation getOccupationById(int idOccupation);

    List<Occupation> getAllOccupations();

}
