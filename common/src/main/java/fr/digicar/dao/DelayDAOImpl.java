package fr.digicar.dao;

import fr.digicar.model.Delay;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class DelayDAOImpl implements DelayDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Delay> findAll() {
        return getCurrentSession().createQuery("FROM Delay").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Delay> filterByDate(Date dateStart, Date dateEnd) {
        Query query = getCurrentSession().createQuery("FROM Delay d WHERE d.date BETWEEN :dateStart AND :dateEnd");
        query.setDate("dateStart", dateStart);
        query.setDate("dateEnd", dateEnd);
        return query.list();

    }

    @Override
    public int count() {
        return ((Number) getCurrentSession().createCriteria(Delay.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
    }

    @Override
    public int countByDate(Date dateStart, Date dateEnd) {
        Query query = getCurrentSession().createQuery("SELECT count(*) FROM Delay d WHERE d.date BETWEEN :dateStart AND :dateEnd");
        query.setDate("dateStart", dateStart);
        query.setDate("dateEnd", dateEnd);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Delay getDelay(int delay_id) { return (Delay) getCurrentSession().get(Delay.class, delay_id);
    }

}
