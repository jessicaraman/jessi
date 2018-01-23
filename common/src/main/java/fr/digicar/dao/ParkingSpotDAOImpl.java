package fr.digicar.dao;

import fr.digicar.model.ParkingSpot;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ParkingSpotDAOImpl implements ParkingSpotDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        getCurrentSession().save(parkingSpot);
    }

    public void updateParkingSpot(ParkingSpot parkingSpot) {
        ParkingSpot parkingSpotUpdate = getParkingSpot(parkingSpot.getId());
        parkingSpotUpdate.setNbSpot(parkingSpot.getNbSpot());
        getCurrentSession().update(parkingSpotUpdate);

    }

    public ParkingSpot getParkingSpot(int id) {
        return (ParkingSpot) getCurrentSession().get(ParkingSpot.class, id);
    }

    public List<ParkingSpot> getParkingSpotByObj(ParkingSpot p) {

        List<ParkingSpot> listPark=new ArrayList<ParkingSpot>();

        if (p.getId()!=null){
            listPark.add((ParkingSpot) getCurrentSession().get(ParkingSpot.class, p.getId()));
        }
        if (p.getNbSpot()!=null){
            listPark.addAll(getCurrentSession().createQuery("FROM ParkingSpot WHERE nbSpot= :nbspot").setParameter("nbspot",p.getNbSpot()).list());
        }
        if (p.getNbParking()!=null){
            listPark.addAll(getCurrentSession().createQuery("FROM ParkingSpot WHERE nbParking=:nbpark").setParameter("nbpark",p.getNbParking()).list());
        }

        if (p.getLocation()!=null){
            listPark.addAll(getCurrentSession().createQuery("FROM ParkingSpot WHERE location=:locat").setParameter("locat",p.getLocation()).list());
        }
        return listPark;
    }

    public void deleteParkingSpot(int id) {
        ParkingSpot parkingSpot = getParkingSpot(id);
        if (parkingSpot != null)
            getCurrentSession().delete(parkingSpot);
    }

    @SuppressWarnings("unchecked")
    public List<ParkingSpot> getParkingSpots() {
        return getCurrentSession().createQuery("FROM ParkingSpot").list();
    }

}