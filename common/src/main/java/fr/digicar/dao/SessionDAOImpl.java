package fr.digicar.dao;

import fr.digicar.model.Car;
import fr.digicar.model.Session;
import org.hibernate.SessionFactory;
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

    public Session getSession(int id) {
        return (Session) getCurrentSession().get(Session.class, id);
    }

    public List<Session> getUserSessions(int userID, Date d) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.MONTH, -1);
        Date minus1= c.getTime();
        String sqlizedstart = convertToDatetime(minus1);
        String sqlizedend=convertToDatetime(d);
        String sql ="FROM Session where id_user="+userID+" and departure_date between '"+sqlizedstart+"' and '"+sqlizedend+"'";
        System.out.print(sql);
        return getCurrentSession().createQuery(sql).list();
    }

    public Car getSessionCar(int sessionId) {
        String sql="From Car c, Session s where c.id=s.id_car and s.id="+sessionId;
        return (Car) getCurrentSession().createQuery(sql).list().get(0);
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
