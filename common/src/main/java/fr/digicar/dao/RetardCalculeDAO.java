package fr.digicar.dao;

import fr.digicar.model.RetardCalcule;

import java.io.IOException;
import java.util.List;

public interface RetardCalculeDAO {

    void addRetardCalcule(RetardCalcule retardCalcule);

    void updateRetardCalcule(RetardCalcule retardCalcule);

    RetardCalcule getRetardCalcule(int id);

    void deleteRetardCalcule(int id);

    List<RetardCalcule> getRetardsCalcule();
    List<RetardCalcule> getRetardCalculeByObj(RetardCalcule p);
    public void addRetardCalculeAutomatically() throws IOException;
    public void deleteAllRetardsCalcule();


}
