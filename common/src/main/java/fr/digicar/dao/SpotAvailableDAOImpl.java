package fr.digicar.dao;

import fr.digicar.model.SpotAvailable;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class SpotAvailableDAOImpl {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    public void updateSpotAvailable(SpotAvailable spotAvailable) {
        try {
            getCurrentSession().update(spotAvailable);
        } catch (JDBCException e) {
            log.error("Error when updating SpotAvailable.", e);
        }
    }

    public SpotAvailable getSpotAvailableById(int id_parking_spots) {

        List<SpotAvailable> list;

        SpotAvailable spotAvailable = new SpotAvailable();
        try {
            list = getCurrentSession().createQuery("FROM places_available WHERE available = 'yes" + spotAvailable + "'").list();
            spotAvailable = null != list && !list.isEmpty() ? list.get(0) : null;
        } catch (JDBCException e) {
            log.error("Error.", e);
        }
        return spotAvailable;
    }


    public List<SpotAvailable> getAllSpotsAvailable() {
        return getCurrentSession().createQuery("FROM places_available").list();
    }

}
