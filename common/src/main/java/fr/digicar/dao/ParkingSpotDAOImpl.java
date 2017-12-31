package fr.digicar.dao;

import fr.digicar.model.ParkingSpot;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class ParkingSpotDAOImpl implements ParkingSpotDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        getCurrentSession().save(parkingSpot);
    }

    /*public void updateParkingSpot(ParkingSpot parkingSpot) {
        ParkingSpot parkinSpotToUpdate = getParkingSpot(parkingSpot.getId());
        parkinSpotToUpdate.setNbSpot(parkingSpot.getNbSpot());
        getCurrentSession().update(parkinSpotToUpdate);

    }

    public ParkingSpot getParkingSpot(int id) {
        return (ParkingSpot) getCurrentSession().get(ParkingSpot.class, id);
    }

    public void deleteParkingSpot(int id) {
        ParkingSpot parkingSpot = getParkingSpot(id);
        if (parkingSpot != null)
            getCurrentSession().delete(parkingSpot);
    }
*/

    @SuppressWarnings("unchecked")
    public List<ParkingSpot> getParkingSpots() {
        return getCurrentSession().createQuery("FROM ParkingSpot").list();
    }

}