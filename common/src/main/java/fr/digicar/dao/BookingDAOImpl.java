package fr.digicar.dao;

import fr.digicar.model.Booking;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingDAOImpl implements BookingDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private org.hibernate.Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Booking getBooking(int id) {
        return (Booking) getCurrentSession().get(Booking.class, id);
    }

    public void removeSessionById(int id){

        try
        {
            Booking booking = getBooking(id);
            getCurrentSession().delete(booking);

        }
        catch(Exception e){
            //Error during hibernate query
        }


    }

    public void updateSessionById(int bookingId, int carId){

        try
        {
            Booking booking = getBooking(bookingId);
            //session.setCar_registration_id("");
            //session.setId_car();
            getCurrentSession().update(booking);

        }
        catch(Exception e){
            //Error during hibernate query
        }
    }

    public List<Booking> getImpactedSessions(String registration, Long arrival_time) {


        List<Booking> resultList = new ArrayList<Booking>();
        String sql ="FROM Booking where car_registration_id="+registration;

        List<Booking> bookingfiltered = new ArrayList<Booking>();

        try{
            resultList = getCurrentSession().createQuery(sql).list();

            Long departureTime;
            for (int i=0; i<resultList.size(); i++){
                departureTime = resultList.get(i).getDeparture_date().getTime();

                if (arrival_time >= departureTime) {

                    bookingfiltered.add(resultList.get(i));
                }

            }
        }
        catch(Exception e) {
            //Error during hibernate query
        }

        return resultList;
    }

    public List<Booking> getAllSessions() {

        List<Booking> resultList = new ArrayList<Booking>();
        String sql ="FROM Booking";

        try{
            resultList = getCurrentSession().createQuery(sql).list();
        }
        catch(Exception e) {
            //Error during hibernate query
        }

        return resultList;
    }
}
