package fr.digicar.backoffice.service;

import fr.digicar.dao.CalculatedDelayDAO;
import fr.digicar.model.CalculatedDelay;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class CalculatedDelayServiceImpl implements CalculatedDelayService {

    @Autowired
    private CalculatedDelayDAO calculatedDelayDAO;

    @Override
    public void addCalculatedDelay(CalculatedDelay calculatedDelay) {
        calculatedDelayDAO.addCalculatedDelay(calculatedDelay);
    }

    @Override
    public void addCalculatedDelayAutomatically() throws IOException, JSONException {
        calculatedDelayDAO.addCalculatedDelaysAutomatically();
    }

    @Override
    public void updateCalculatedDelay(CalculatedDelay calculatedDelay) {
        calculatedDelayDAO.updateCalculatedDelay(calculatedDelay);
    }

    @Override
    public CalculatedDelay getCalculatedDelayById(int id) {
        return calculatedDelayDAO.getCalculatedDelayById(id);
    }

    @Override
    public void deleteCalculatedDelay(int id) {
        calculatedDelayDAO.deleteCalculatedDelay(id);
    }

    @Override
    public List<CalculatedDelay> getCalculatedDelays() {
        return calculatedDelayDAO.getCalculatedDelays();
    }

    @Override
    public List<CalculatedDelay> getCalulatedDelaysByObj(CalculatedDelay p) {
        return calculatedDelayDAO.getCalculatedDelaysByObj(p);
    }

    @Override
    public void deleteAllCalculatedDelays() {
        calculatedDelayDAO.deleteAllCalculatedDelays();
    }

}
