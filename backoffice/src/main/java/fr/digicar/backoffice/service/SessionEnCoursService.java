package fr.digicar.backoffice.service;

import fr.digicar.model.SessionEnCours;

import java.util.List;

public interface SessionEnCoursService {

    void addSessionEnCours(SessionEnCours sessionEnCours);

    void updateSessionEnCours(SessionEnCours sessionEnCours);

    SessionEnCours getSessionEnCours(int id);

    void deleteSessionEnCours(int id);

    List<SessionEnCours> getSessionsEnCours();
    List<SessionEnCours> getSessionEnCoursByObj(SessionEnCours p);

}
