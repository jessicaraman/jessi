package fr.digicar.backoffice.service;

import fr.digicar.dao.CurrentSessionDAO;
import fr.digicar.model.CurrentSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CurrentSessionServiceImpl implements CurrentSessionService {

    @Autowired
    private CurrentSessionDAO currentSessionDAO;

    @Override
    public void addCurrentSession(CurrentSession currentSession) {
        currentSessionDAO.addCurrentSession(currentSession);
    }

    @Override
    public void updateCurrentSession(CurrentSession currentSession) {
        currentSessionDAO.updateCurrentSession(currentSession);
    }

    @Override
    public CurrentSession getCurrentSessionById(int id) {
        return currentSessionDAO.getCurrentSessionById(id);
    }

    @Override
    public void deleteCurrentSession(int id) {
        currentSessionDAO.deleteCurrentSession(id);
    }

    @Override
    public List<CurrentSession> getCurrentSessions() {
        return currentSessionDAO.getCurrentSessions();
    }

    @Override
    public List<CurrentSession> getCurrentSessionsByObj(CurrentSession p) {
        return currentSessionDAO.getCurrentSessionsByObj(p);
    }

}
