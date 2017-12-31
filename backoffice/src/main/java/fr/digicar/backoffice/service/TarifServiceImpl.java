package fr.digicar.backoffice.service;
import fr.digicar.model.*;
import fr.digicar.dao.TarifDAO;
import fr.digicar.model.Tarif;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TarifServiceImpl {

    @Autowired
    private TarifDAO tarifDAO;

    public void addTarif(Tarif tarif) {
        tarifDAO.addTarif(tarif);
    }

    public void updateTarif(Tarif tarif) {
        tarifDAO.updateTarif(tarif);
    }

    public Tarif getTarif(int id) {
        return tarifDAO.getTarif(id);
    }

    public void deleteTarif(int id) {
        tarifDAO.deleteTarif(id);
    }

    public List<Tarif> getTarifs() {
        return tarifDAO.getTarifs();
    }

}
