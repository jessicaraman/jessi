package fr.digicar.dao;

import fr.digicar.model.Car;
import fr.digicar.model.Session;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class SessionDAOImpl implements SessionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private org.hibernate.Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Session getSession(int id) {
        return (Session) getCurrentSession().get(Session.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Session> getUserSessions(int userId, Date today) {
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.MONTH, -1);
        Date oneMonthAgo = c.getTime();
        String hql = "FROM Session WHERE user = :userId and departure_date BETWEEN :dateStart AND :dateEnd";
        return getCurrentSession().createQuery(hql)
                .setParameter("userId", userId)
                .setDate("dateStart", oneMonthAgo)
                .setDate("dateEnd", today)
                .list();
    }

    @Override
    public Car getSessionCar(int sessionId) {
        Session s = this.getSession(sessionId);
        Criteria cr = getCurrentSession().createCriteria(Car.class);
        Criterion id = Restrictions.gt("id", s.getCar());
        cr.add(id);
        return (Car) cr.list().get(0);
    }

}
