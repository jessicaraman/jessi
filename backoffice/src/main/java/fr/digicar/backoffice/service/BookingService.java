package fr.digicar.backoffice.service;

import fr.digicar.model.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> getImpactedBookings(String registration, Long arrival_time);
    List<Booking> getAllBookings();
    void removeBookingById(int id);
    void updateBookingById(int bookingId, int carId);
}
