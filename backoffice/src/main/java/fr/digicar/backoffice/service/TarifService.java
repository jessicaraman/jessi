package fr.digicar.backoffice.service;

import java.util.List;

import fr.digicar.model.Tarif;

public interface TarifService {

    void addTarif(Tarif tarif);
    void updateTarif(Tarif tarif);
    Tarif getTarif(int id);
    void deleteTarif(int id);
    List<Tarif> getTarifs();

}
