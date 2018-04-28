package fr.digicar.dao;

import fr.digicar.model.Car;
import fr.digicar.model.Session;
import org.hibernate.Criteria;
import org.hibernate.JDBCException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class SessionDAOImpl implements SessionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void removeSessionById(int id){

        try
        {
            Session session = getSession(id);
            getCurrentSession().delete(session);

        }
        catch(Exception e){
            //Error during hibernate query
        }


    }

    public void updateSessionById(int sessionId, int carId){

            try
            {
                Session session = getSession(sessionId);
                //session.setCar_registration_id("");
                //session.setId_car();
                getCurrentSession().update(session);

            }
            catch(Exception e){
                //Error during hibernate query
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
    public List<Session> getImpactedSessions(String registration, Long arrival_time) {


        List<Session> resultList = new ArrayList<Session>();
        String sql ="FROM Session where car_registration_id="+registration;

        List<Session> sessionfiltered = new ArrayList<Session>();

        try{
            resultList = getCurrentSession().createQuery(sql).list();

            Long departureTime;
            for (int i=0; i<resultList.size(); i++){
                departureTime = resultList.get(i).getDeparture_date().getTime();

                if (arrival_time >= departureTime) {

                    sessionfiltered.add(resultList.get(i));
                }

            }
        }
        catch(Exception e) {
            //Error during hibernate query
        }

        return resultList;
    }

    public List<Session> getAllSessions() {

        List<Session> resultList = new ArrayList<Session>();
        String sql ="FROM Session";

        try{
            resultList = getCurrentSession().createQuery(sql).list();
        }
        catch(Exception e) {
            //Error during hibernate query
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
