package fr.digicar.dao;

import fr.digicar.model.Car;
import fr.digicar.model.Session;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@Repository
public class SessionDAOImpl implements SessionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void removeSessionById(int id) {
        try {
            Session session = getSession(id);
            getCurrentSession().delete(session);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void updateSessionById(int sessionId, int carId) {
        try {
            Session session = getSession(sessionId);
            //session.setCar_registration_id("");
            //session.setId_car();
            getCurrentSession().update(session);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

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
    @SuppressWarnings("unchecked")
    public List<Session> getImpactedSessions(String registration, Long arrivalTime) {
        List<Session> resultList = new ArrayList<>();
        List<Session> filteredSessions = new ArrayList<>();

        try {
            resultList = getCurrentSession()
                    .createQuery("FROM Session WHERE car_registration_id = :registration")
                    .setParameter("registration", registration)
                    .list();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        Long departureTime;
        for (Session result : resultList) {
            departureTime = result.getDepartureDate().getTime();
            if (arrivalTime >= departureTime) {
                filteredSessions.add(result);
            }
        }

        return filteredSessions;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Session> getAllSessions() {
        List<Session> resultList = new ArrayList<>();

        try {
            resultList = getCurrentSession().createQuery("FROM Session").list();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return resultList;
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
