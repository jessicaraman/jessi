package fr.digicar.backoffice.service;

import fr.digicar.model.CurrentSession;

import java.util.List;

public interface CurrentSessionService {

    void addCurrentSession(CurrentSession currentSession);

    void updateCurrentSession(CurrentSession currentSession);

    CurrentSession getCurrentSessionById(int id);

    void deleteCurrentSession(int id);

    List<CurrentSession> getCurrentSessions();

    List<CurrentSession> getCurrentSessionsByObj(CurrentSession p);

}
