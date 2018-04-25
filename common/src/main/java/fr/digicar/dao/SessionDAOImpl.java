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

    private org.hibernate.Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Session getSession(int id) {
        return (Session) getCurrentSession().get(Session.class, id);
    }

    public List<Session> getUserSessions(int userID, Date d) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.MONTH, -1);
        Date minus1= c.getTime();
        String sqlizedstart = convertToDatetim(minus1);
        String sqlizedend=convertToDatetim(d);
        String sql ="FROM Session where id_user="+userID+" and departure_date between '"+sqlizedstart+"' and '"+sqlizedend+"'";
        System.out.print(sql);
        return getCurrentSession().createQuery(sql).list();
    }

    public Car getSessionCar(int sessionId) {
        Session s=this.getSession(sessionId);
        Criteria cr = getCurrentSession().createCriteria(Car.class);

        Criterion id = Restrictions.gt("id", s.getId_car());
        cr.add( id );

       return (Car) cr.list().get(0);
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
    private static String convertToDatetime(Date d){
    java.text.SimpleDateFormat sdf =
            new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");

    return sdf.format(d);}
    private static String convertToDatetim(Date d){
    java.text.SimpleDateFormat sdf =
            new java.text.SimpleDateFormat("yyyy-MM-dd");

    return sdf.format(d);}

}
