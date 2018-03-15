package fr.digicar.backoffice.service;

import fr.digicar.model.RetardCalcule;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface RetardCalculeService {

    void addRetardCalcule(RetardCalcule retardCalcule);
    void addRetardCalculeAutomatically() throws IOException, JSONException;

    void addRetardCalculeAutomatically() throws IOException;

    void updateRetardCalcule(RetardCalcule retardCalcule);

    RetardCalcule getRetardCalcule(int id);

    void deleteRetardCalcule(int id);

    List<RetardCalcule> getRetardsCalcule();
    List<RetardCalcule> getRetardCalculeByObj(RetardCalcule p);

    void deleteAllRetardsCalcule();
}
