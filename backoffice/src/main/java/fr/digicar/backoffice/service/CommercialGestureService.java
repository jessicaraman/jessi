package fr.digicar.backoffice.service;

import fr.digicar.model.CommercialGesture;

import java.util.List;

public interface CommercialGestureService {
    List<CommercialGesture> getAllCommeercialGesture();
    List<CommercialGesture> getFirstCommercialGestureFree();
}
