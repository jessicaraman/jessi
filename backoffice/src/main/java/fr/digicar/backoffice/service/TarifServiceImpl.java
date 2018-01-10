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

}
