package fr.digicar.dao;

import fr.digicar.model.TransmissionMode;

import java.util.List;

public interface TransmissionModeDAO {

    void addTransmissionMode(TransmissionMode transmissionMode);

    List<TransmissionMode> getAllTransmissionMode();

}
