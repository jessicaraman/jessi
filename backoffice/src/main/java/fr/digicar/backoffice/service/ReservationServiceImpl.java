package fr.digicar.backoffice.service;

import fr.digicar.dao.ReservationDAO;
import fr.digicar.model.Reservation;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationDAO reservationDAO;

    @Override
    public void addReservation(Reservation reservation) {
        reservationDAO.addReservation(reservation);
    }

    @Override
    public void updateReservation(Reservation reservation) throws JDBCException {
        reservationDAO.updateReservation(reservation);
    }

    @Override
    public Reservation getReservationById(int id) {
        return reservationDAO.getReservationById(id);
    }

    @Override
    public void deleteReservation(int id) {
        reservationDAO.deleteReservation(id);
    }

    @Override
    public List<Reservation> getReservationByCriteria(Date start_time, Date end_time, Integer place_back) {
        return reservationDAO.getReservationByCriteria(start_time, end_time, place_back);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationDAO.getAllReservations();
    }
}
