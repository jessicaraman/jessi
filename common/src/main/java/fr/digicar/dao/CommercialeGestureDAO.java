package fr.digicar.dao;

import fr.digicar.model.CommercialGesture;

import java.util.List;

public interface CommercialeGestureDAO {
    List<CommercialGesture> getAllCommeercialGesture();
    List<CommercialGesture> getFirstCommercialGestureFree();
    void updateCommercialGestureForUser(int id_user, String code);

}
