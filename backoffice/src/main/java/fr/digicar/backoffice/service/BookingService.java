package fr.digicar.backoffice.service;

import fr.digicar.model.Booking;

import java.sql.Timestamp;
import java.util.List;

public interface BookingService {

    List<Booking> getImpactedBookings(String registration, Long arrival_time);
    Booking getBooking(int id);
    List<Booking> getAllBookings();
    void removeBookingById(int id);
    void updateBookingById(int bookingId, int carId);
    void updateHourBooking(int bookingId, Timestamp date);
}
