package fr.digicar.dao;
import fr.digicar.model.Tarif;

import java.util.List;

public interface TarifDAO {
    public void addTarif(Tarif tarif);
    public void updateTarif(Tarif tarif);
    public Tarif getTarif(int id);
    public void deleteTarif(int id);
    public List<Tarif> getTarifs();
}
