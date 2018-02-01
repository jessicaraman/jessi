package fr.digicar.backoffice.service;

import fr.digicar.model.TransmissionMode;

import java.util.List;

/**
 * Created by barry on 31/12/2017.
 */
public interface TransmissionModeService {
    void addTransmissionMode(TransmissionMode transmissionMode);
    List<TransmissionMode> getAllTransmissionMode();
}
