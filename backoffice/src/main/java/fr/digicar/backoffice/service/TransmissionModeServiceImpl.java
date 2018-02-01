package fr.digicar.backoffice.service;

/**
 * Created by barry on 31/12/2017.
 */

import fr.digicar.dao.TransmissionModeDAO;
import fr.digicar.model.TransmissionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransmissionModeServiceImpl implements TransmissionModeService {

    @Autowired
    private TransmissionModeDAO transmissionModeDAO;

    @Override
    public void addTransmissionMode(TransmissionMode transmissionMode) {
        transmissionModeDAO.addTransmissionMode(transmissionMode);
    }

    @Override
    public List<TransmissionMode> getAllTransmissionMode() {
        return transmissionModeDAO.getAllTransmissionMode();
    }

}
