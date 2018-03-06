package fr.digicar.backoffice.service;

import java.util.List;

import fr.digicar.model.Tarif;

public interface TarifService {

    void addTarif(Tarif tarif);
    void updateTarif(Tarif tarif);
    Tarif getTarif(int id);
    void deleteTarif(int id);
    List<Tarif> getTarifs();
    List<Tarif> searchTarifs(String libelle,float prix_km_min, float prix_km_max,float prix_heure_min,
                             float prix_heure_max,int frais_mensuels_min, int frais_mensuels_max);

}
