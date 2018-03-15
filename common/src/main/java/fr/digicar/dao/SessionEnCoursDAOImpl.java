package fr.digicar.dao;

import fr.digicar.model.SessionEnCours;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class SessionEnCoursDAOImpl implements SessionEnCoursDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addSessionEnCours(SessionEnCours sessionEnCours) {
        getCurrentSession().save(sessionEnCours);
    }

   

    public void updateSessionEnCours(SessionEnCours sessionEnCours) {
        SessionEnCours sessionEnCoursUpdate = getSessionEnCours(sessionEnCours.getIdSession());

        sessionEnCoursUpdate.setTag(sessionEnCours.isTag());

        getCurrentSession().update(sessionEnCoursUpdate);

    }

    public SessionEnCours getSessionEnCours(int id) {
        return (SessionEnCours) getCurrentSession().get(SessionEnCours.class, id);
    }

    public List<SessionEnCours> getSessionEnCoursByObj(SessionEnCours p) {


        List<SessionEnCours> listRetard=new ArrayList<SessionEnCours>();

        return listRetard;
    }

    public void deleteSessionEnCours(int id) {
        SessionEnCours sessionEnCours = getSessionEnCours(id);
        if (sessionEnCours != null)
            getCurrentSession().delete(sessionEnCours);
    }

    @SuppressWarnings("unchecked")

    public List<SessionEnCours> getSessionsEnCours() {
        return getCurrentSession().createQuery("FROM SessionEnCours").list();
    }




}
