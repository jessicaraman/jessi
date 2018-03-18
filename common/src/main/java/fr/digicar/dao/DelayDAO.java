package fr.digicar.dao;

import fr.digicar.model.Delay;

import java.util.Date;
import java.util.List;

public interface DelayDAO {

    List findAll();

    List<Delay> filterByDate(Date dateStart, Date dateEnd);

    int count();

    int countByDate(Date dateStart, Date dateEnd);

}
