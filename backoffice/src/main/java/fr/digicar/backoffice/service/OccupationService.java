package fr.digicar.backoffice.service;

import fr.digicar.model.Occupation;

import java.util.List;

public interface OccupationService {

    Occupation getOccupationById(int idOccupation);

    List<Occupation> getAllOccupations();

}
