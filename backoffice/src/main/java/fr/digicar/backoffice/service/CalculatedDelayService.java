package fr.digicar.backoffice.service;

import fr.digicar.model.CalculatedDelay;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface CalculatedDelayService {

    void addCalculatedDelay(CalculatedDelay calculatedDelay);

    void addCalculatedDelayAutomatically() throws IOException, JSONException;

    void updateCalculatedDelay(CalculatedDelay calculatedDelay);

    CalculatedDelay getCalculatedDelayById(int id);

    void deleteCalculatedDelay(int id);

    List<CalculatedDelay> getCalculatedDelays();

    List<CalculatedDelay> getCalulatedDelaysByObj(CalculatedDelay p);

    void deleteAllCalculatedDelays();

}
