package fr.digicar.backoffice.service;

import fr.digicar.dao.OccupationDAO;
import fr.digicar.model.Occupation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OccupationServiceImpl implements OccupationService{

    @Autowired
    private OccupationDAO occupationDAO;

    @Override
    public Occupation getOccupationById(int idOccupation){
        return occupationDAO.getOccupationById(idOccupation);
    }

    @Override
    public List<Occupation> getAllOccupations(){
        return occupationDAO.getAllOccupations();
    }

}
