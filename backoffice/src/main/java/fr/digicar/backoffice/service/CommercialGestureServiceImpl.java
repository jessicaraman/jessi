package fr.digicar.backoffice.service;

import fr.digicar.dao.CommercialeGestureDAO;
import fr.digicar.model.CommercialGesture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommercialGestureServiceImpl implements CommercialGestureService{
    @Autowired
    private CommercialeGestureDAO commercialeGestureDAO;

    @Override
    public List<CommercialGesture> getAllCommeercialGesture(){
        return commercialeGestureDAO.getAllCommeercialGesture();
    }
    @Override
    public List<CommercialGesture> getFirstCommercialGestureFree(){
        return commercialeGestureDAO.getFirstCommercialGestureFree();
    }

    @Override
    public void  updateCommercialGestureForUser(int id_user, String code) { commercialeGestureDAO.updateCommercialGestureForUser(id_user, code);
    }
}
