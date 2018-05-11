package fr.digicar.backoffice.service;

import fr.digicar.backoffice.utils.DelayDistribution;
import fr.digicar.model.Delay;

import java.util.Date;

public interface DelayService {

    DelayDistribution getDelayDistribution(Date dateStart, Date dateEnd);

    int getDelayNumber(Date dateStart, Date dateEnd);
    Delay getDelay(int id);

}
