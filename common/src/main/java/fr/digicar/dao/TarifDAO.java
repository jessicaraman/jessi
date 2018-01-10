package fr.digicar.dao;

import fr.digicar.model.Tarif;

import java.util.List;

public interface TarifDAO {

    void addTarif(Tarif tarif);

    void updateTarif(Tarif tarif);

    Tarif getTarif(int id);

    void deleteTarif(int id);

    List<Tarif> getTarifs();

}
