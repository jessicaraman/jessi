package fr.digicar.dao;

import fr.digicar.model.Booking;

import java.sql.Timestamp;
import java.util.List;

public interface BookingDAO {

    Booking getBooking(int id);
    List<Booking> getImpactedSessions(String registration, Long arrival_time);
    List<Booking>getAllSessions();
    void removeSessionById(int id);
    void updateBookingById(int sessionId, int carId);
    void updateHourBooking(int sessionId, Timestamp date);
}
