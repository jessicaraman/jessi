package fr.digicar.dao;

import fr.digicar.model.CurrentSession;

import java.util.List;

public interface CurrentSessionDAO {

    void addCurrentSession(CurrentSession currentSession);

    void updateCurrentSession(CurrentSession currentSession);

    CurrentSession getCurrentSessionById(int id);

    void deleteCurrentSession(int id);

    List<CurrentSession> getCurrentSessions();

    List<CurrentSession> getCurrentSessionsByObj(CurrentSession p);

}
