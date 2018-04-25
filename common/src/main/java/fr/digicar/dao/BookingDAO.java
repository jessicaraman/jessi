package fr.digicar.dao;

import fr.digicar.model.Booking;

import java.util.List;

public interface BookingDAO {

    Booking getBooking(int id);
    List<Booking> getImpactedSessions(String registration, Long arrival_time);
    List<Booking>getAllSessions();
    void removeSessionById(int id);
    void updateSessionById(int sessionId, int carId);
}
