package fr.digicar.dao;

import fr.digicar.model.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Repository
public class ReservationDAOImpl implements ReservationDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addReservation(Reservation reservation) {
        getCurrentSession().save(reservation);
    }

    @Override
    public void updateReservation(Reservation reservation) throws JDBCException {
        try {
            getCurrentSession().update(reservation);
        } catch (JDBCException e) {
            log.error("Error when updating Reservation.", e);
        }
    }

    @Override
    public Reservation getReservationById(int id) {
        return (Reservation) getCurrentSession().get(Reservation.class, id);
    }

    @Override
    public void deleteReservation(int id) {
        try {
            Reservation reservation = (Reservation) getCurrentSession().load(Reservation.class, id);
            if (reservation != null)
                getCurrentSession().delete(reservation);
        } catch (JDBCException e) {
            log.error("Error when deleting Reservation " + id, e);
        }
    }

    @Override
    public List<Reservation> getReservationByCriteria(Date start_time, Date end_time, Integer place_back) {
        String findByCriteriaQueryString = buildFindByCriteriaQuery(start_time, end_time, place_back);

        List<Reservation> resultList = new ArrayList<>();
        try {
            resultList = getCurrentSession().createQuery(findByCriteriaQueryString).list();
        } catch (JDBCException e) {
            log.error("Error when returning Reservation.", e);
        }

        return resultList;
    }

    private String buildFindByCriteriaQuery(Date start_time, Date end_time, Integer place_back) {
        String query = "FROM reservation WHERE";
        String querypParam = "";
        if (null != start_time && !start_time.toString().isEmpty()) {
            querypParam += " start_time = '" + start_time + "'";
        }
        if (null != end_time && !end_time.toString().isEmpty()) {
            querypParam += " AND end_time = '" + end_time + "'";
        }
        if ((null != place_back) && !place_back.toString().isEmpty()) {
            querypParam += " AND type = '" + place_back + "'";
        }

        querypParam += " ORDER BY start_time ASC ";
        query += querypParam;
        return query;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return getCurrentSession().createQuery("FROM Reservation").list();
    }
}
