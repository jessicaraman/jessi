package fr.digicar.dao;

import fr.digicar.model.Booking;
import fr.digicar.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
    public Car getCar(int id) {
        return (Car) getCurrentSession().get(Car.class, id);
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

    public void updateHourBooking(int bookingId, Timestamp date){

        try
        {
            String sqlQuery = "UPDATE booking SET departure_date='"+date+"'" +" WHERE id='"+bookingId+"'";

            getCurrentSession().createSQLQuery(sqlQuery).executeUpdate();

            getCurrentSession().beginTransaction().commit();

        }
        catch(Exception e){
            //Error during hibernate query
        }
    }

    public void updateBookingById(int bookingId, int carId){

            try
            {
                Car car =getCar(carId);

                String sqlQuery = "UPDATE booking SET id_car='"+carId+"', " + "car_registration_id='"+car.getRegistrationNumber()+"'" +" WHERE id='"+bookingId+"'";

                getCurrentSession().createSQLQuery(sqlQuery).executeUpdate();

                getCurrentSession().beginTransaction().commit();
                //voir si c'est bien ajouté dans booking

            }
            catch(Exception e){
                //Error during hibernate query
            }
        }

    public List<Booking> getImpactedSessions(String registration, Long arrival_time) {


        List<Booking> resultList = new ArrayList<Booking>();
        String sql ="FROM Booking where car_registration_id='"+registration+"'";

        List<Booking> bookingfiltered = new ArrayList<Booking>();

        try{
            resultList = getCurrentSession().createQuery(sql).list();

            Long departureTime;
            for (int i=0; i<resultList.size(); i++){
                departureTime = resultList.get(i).getDeparture_date().getTime();

                if (arrival_time > departureTime) {

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
