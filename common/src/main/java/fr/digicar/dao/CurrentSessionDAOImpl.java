package fr.digicar.dao;

import fr.digicar.model.CurrentSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CurrentSessionDAOImpl implements CurrentSessionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCurrentSession(CurrentSession currentSession) {
        getCurrentSession().save(currentSession);
    }

    @Override
    public void updateCurrentSession(CurrentSession currentSession) {
        CurrentSession currentSessionUpdate = getCurrentSessionById(currentSession.getId());
        currentSessionUpdate.setTag(currentSession.isTag());
        getCurrentSession().update(currentSessionUpdate);
    }

    @Override
    public CurrentSession getCurrentSessionById(int id) {
        return (CurrentSession) getCurrentSession().get(CurrentSession.class, id);
    }

    @Override
    public List<CurrentSession> getCurrentSessionsByObj(CurrentSession p) {
        return new ArrayList<>();
    }

    @Override
    public void deleteCurrentSession(int id) {
        CurrentSession currentSession = getCurrentSessionById(id);
        if (currentSession != null)
            getCurrentSession().delete(currentSession);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CurrentSession> getCurrentSessions() {
        return getCurrentSession().createQuery("FROM CurrentSession").list();
    }

}
