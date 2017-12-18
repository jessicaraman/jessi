package fr.digicar.service;

import java.util.List;

import fr.digicar.model.Tarif;

public interface TarifService {

    public void addTarif(Tarif tarif);
    public void updateTarif(Tarif tarif);
    public Tarif getTarif(int id);
    public void deleteTarif(int id);
    public List<Tarif> getTarifs();

}
