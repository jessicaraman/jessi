package fr.digicar.backoffice.service;

import fr.digicar.dao.DelayDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DelayServiceImpl implements DelayService {

    @Autowired
    private DelayDAO delayDAO;

    @Override
    public int getDelayNumber() {
        return delayDAO.findAll().size();
    }

}
