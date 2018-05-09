package fr.digicar.dao;

import fr.digicar.model.Parking;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class ParkingDAOImpl implements ParkingDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Parking getParkingById(int id) {
        List<Parking> list;

        Parking parking = new Parking();
        try {
            list = getCurrentSession().createQuery("FROM parking WHERE id = '" + id + "'").list();
            parking = null != list && !list.isEmpty() ? list.get(0) : null;
        } catch (JDBCException e) {
            log.error("Error, could not find any parking.", e);
        }
        return parking;
    }

    @Override
    public List<Parking> getAllParkings() {
        return getCurrentSession().createQuery("FROM parking").list();
    }
}
