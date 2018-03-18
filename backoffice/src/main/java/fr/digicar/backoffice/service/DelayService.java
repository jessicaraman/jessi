package fr.digicar.backoffice.service;

import fr.digicar.backoffice.utils.DelayDistribution;

import java.util.Date;

public interface DelayService {

    DelayDistribution getDelayDistribution(Date dateStart, Date dateEnd);

    int getDelayNumber(Date dateStart, Date dateEnd);

}
