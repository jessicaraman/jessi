package fr.digicar.webportal.service;

import fr.digicar.model.Occupation;

import java.util.List;


public interface OccupationService {

    Occupation getOccupationById(int id_occupation);
    List<Occupation> getAllOccupations();
}
