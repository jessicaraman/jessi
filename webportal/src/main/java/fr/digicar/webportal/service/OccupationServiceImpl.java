package fr.digicar.webportal.service;

import fr.digicar.dao.OccupationDAO;
import fr.digicar.model.Occupation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("occupationService")
@Transactional
public class OccupationServiceImpl implements OccupationService{

    @Autowired
    private OccupationDAO occupationDAO;

    @Override
    Occupation getOccupationtyById(int id_occupation){

        return occupationDAO.getOccupationById(id_occupation);
    }
}
