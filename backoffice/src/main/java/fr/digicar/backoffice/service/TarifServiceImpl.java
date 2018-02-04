package fr.digicar.backoffice.service;
import fr.digicar.dao.TarifDAO;
import fr.digicar.model.Tarif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TarifServiceImpl implements TarifService {

    @Autowired
    private TarifDAO tarifDAO;

    @Override
    public void addTarif(Tarif tarif) {
        tarifDAO.addTarif(tarif);
    }

    @Override
    public void updateTarif(Tarif tarif) {
        tarifDAO.updateTarif(tarif);
    }

    @Override
    public Tarif getTarif(int id) {
        return tarifDAO.getTarif(id);
    }

    @Override
    public void deleteTarif(int id) {
        tarifDAO.deleteTarif(id);
    }

    @Override
    public List<Tarif> getTarifs() {
        return tarifDAO.getTarifs();
    }

    @Override
    public List<Tarif> searchTarifs(String libelle,float prix_km_min, float prix_km_max,float prix_heure_min,
                                    float prix_heure_max,int frais_mensuels_min, int frais_mensuels_max) {
        return tarifDAO.searchTarifs(libelle,prix_km_min,prix_km_max,prix_heure_min,prix_heure_max,frais_mensuels_min,frais_mensuels_max);
    }

}
