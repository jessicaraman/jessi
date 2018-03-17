package fr.digicar.backoffice.service;

import fr.digicar.backoffice.utils.DelayDistribution;

public interface DelayService {

    DelayDistribution getDelayDistribution();

    int getDelayNumber();

}
