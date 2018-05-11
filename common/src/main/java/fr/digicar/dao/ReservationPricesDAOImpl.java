package fr.digicar.dao;

import fr.digicar.model.ReservationPrices;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class ReservationPricesDAOImpl implements ReservationPricesDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public ReservationPrices getReservationPriceById(int id) {
        List<ReservationPrices> list;

        ReservationPrices reservationPrices = new ReservationPrices();
        try {
            list = getCurrentSession().createQuery("FROM Pricing WHERE id = '" + id + "'").list();
            reservationPrices = !list.isEmpty() &&  list != null  ? list.get(0) : null;
        } catch (JDBCException e) {
            log.error("Error, could not find any available spot.", e);
        }
        return reservationPrices;
    }

    @Override
    public ReservationPrices getReservationPriceByCriterias(int carType, int fuelType){
        List<ReservationPrices> list;

        ReservationPrices reservationPrices = new ReservationPrices();
        try {
            list = getCurrentSession().createQuery("FROM ReservationPrices WHERE id_car_type = '" + carType + "' and id_fuel_type = '"+fuelType+"'").list();
            reservationPrices = (!list.isEmpty() &&  list != null ) ? list.get(0) : null;
        } catch (JDBCException e) {
            log.error("Error, could not find any available spot.", e);
        }
        return reservationPrices;
    }


    @Override
    public List<ReservationPrices> getAllReservationPrices() {
        return getCurrentSession().createQuery("FROM Pricing").list();    }
}
