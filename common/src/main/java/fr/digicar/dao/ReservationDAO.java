package fr.digicar.dao;

import fr.digicar.model.Reservation;
import org.hibernate.JDBCException;

import java.util.Date;
import java.util.List;

public interface ReservationDAO {

    void addReservation(Reservation reservation);

    void updateReservation(Reservation reservation) throws JDBCException;

    Reservation getReservationById(int id);

    void deleteReservation(int id);

    List<Reservation> getReservationByCriteria(Date start_time, Date end_time, Integer place_back);

    List<Reservation> getAllReservations();

}
