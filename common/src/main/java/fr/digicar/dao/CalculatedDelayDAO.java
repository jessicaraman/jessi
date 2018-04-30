package fr.digicar.dao;

import fr.digicar.model.CalculatedDelay;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface CalculatedDelayDAO {

    void addCalculatedDelay(CalculatedDelay calculatedDelay);

    void updateCalculatedDelay(CalculatedDelay calculatedDelay);

    CalculatedDelay getCalculatedDelayById(int id);

    void deleteCalculatedDelay(int id);

    List<CalculatedDelay> getCalculatedDelays();

    List<CalculatedDelay> getCalculatedDelaysByObj(CalculatedDelay p);

    void deleteAllCalculatedDelays();

    void addCalculatedDelaysAutomatically() throws IOException, JSONException;

}
