package fr.digicar.dao;

import fr.digicar.model.Delay;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DelayDAOImpl implements DelayDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<Delay> findAll() {
        return getCurrentSession().createQuery("FROM Delay").list();
    }

    public int count() {
        return ((Number) getCurrentSession().createCriteria(Delay.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
    }

}
