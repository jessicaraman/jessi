package fr.digicar.backoffice.emergency_modification.service;


import fr.digicar.dao.BookingDAO;
import fr.digicar.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDAO bookingDAO;

    @Override
    public List<Booking> getImpactedBookings(String registration, Long arrival_time){return bookingDAO.getImpactedSessions(registration, arrival_time);}

    @Override
    public List<Booking> getAllBookings(){return bookingDAO.getAllSessions();}

    @Override
    public void removeBookingById(int id) { bookingDAO.removeSessionById(id);
    }

    @Override
    public void updateBookingById(int bookingId, int carId) { bookingDAO.updateSessionById(bookingId, carId);
    }

}
