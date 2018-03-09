package fr.digicar.backoffice.service;

import fr.digicar.dao.RetardCalculeDAO;
import fr.digicar.model.RetardCalcule;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class RetardCalculeServiceImpl implements RetardCalculeService {

    @Autowired
    private RetardCalculeDAO retardCalculeDAO;

    @Override
    public void addRetardCalcule(RetardCalcule retardCalcule) {
        retardCalculeDAO.addRetardCalcule(retardCalcule);
    }

    @Override
    public void addRetardCalculeAutomatically() throws IOException, JSONException{retardCalculeDAO.addRetardCalculeAutomatically();}

    @Override
    public void updateRetardCalcule(RetardCalcule retardCalcule) {
        retardCalculeDAO.updateRetardCalcule(retardCalcule);
    }

    @Override
    public RetardCalcule getRetardCalcule(int id) {
        return retardCalculeDAO.getRetardCalcule(id);
    }

    @Override
    public void deleteRetardCalcule(int id) {
        retardCalculeDAO.deleteRetardCalcule(id);
    }

    @Override
    public List<RetardCalcule> getRetardsCalcule() {
        return retardCalculeDAO.getRetardsCalcule();
    }

    @Override
    public List<RetardCalcule> getRetardCalculeByObj(RetardCalcule p) {
        return retardCalculeDAO.getRetardCalculeByObj(p);
    }

}
