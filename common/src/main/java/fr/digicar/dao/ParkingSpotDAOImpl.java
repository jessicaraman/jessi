package fr.digicar.dao;

import fr.digicar.model.ParkingSpot;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import com.google.maps.*;
import com.google.maps.model.GeocodingResult;



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
        System.out.println(p.getNbSpot()+" place "+p.getLocation()+" VILLE  "+p.getNbParking()+" parking");
        System.out.println((p.getNbSpot()!=null) +"/"+ !p.getNbParking().equals("")+"/"+!p.getLocation().equals(""));
        /*if (p.getNbSpot()!=null&&!p.getNbParking().equals("")&&!p.getLocation().equals("")){
            Query query=getCurrentSession().createQuery("FROM ParkingSpot WHERE nbSpot=:nbspot AND nbParking=:nbpark AND location=:locat");
            query.setParameter("nbspot",p.getNbSpot());
            query.setParameter("nbpark",p.getNbParking());
            query.setParameter("locat",p.getLocation());
            listPark.addAll(query.list());
            System.out.println(listPark.size()+" TAILLE ");

                }*/

        if (p.getNbSpot()!=null){
            if(!p.getNbParking().equals("")){
                if(!p.getLocation().equals("")){
                    listPark.addAll(getCurrentSession().createQuery("FROM ParkingSpot WHERE nbSpot= :nbspot AND nbParking=:nbpark AND location=:locat")
                            .setParameter("nbspot",p.getNbSpot())
                            .setParameter("nbpark",p.getNbParking())
                            .setParameter("locat",p.getLocation()).list());
                }
                else {
                    listPark.addAll(getCurrentSession().createQuery("FROM ParkingSpot WHERE nbSpot= :nbspot AND nbParking=:nbpark")
                            .setParameter("nbspot",p.getNbSpot())
                            .setParameter("nbpark",p.getNbParking()).list());
                }
            }
            else {
                if(!p.getLocation().equals("")){
                    listPark.addAll(getCurrentSession().createQuery("FROM ParkingSpot WHERE nbSpot= :nbspot AND location=:locat")
                            .setParameter("nbspot",p.getNbSpot())

                            .setParameter("locat",p.getLocation()).list());
                }
                else {
                    listPark.addAll(getCurrentSession().createQuery("FROM ParkingSpot WHERE nbSpot= :nbspot")
                            .setParameter("nbspot",p.getNbSpot()).list());
                }
            }
        }
        else{
            if(!p.getNbParking().equals("")){
                if(!p.getLocation().equals("")){
                    listPark.addAll(getCurrentSession().createQuery("FROM ParkingSpot WHERE nbParking=:nbpark AND location=:locat")

                            .setParameter("nbpark",p.getNbParking())
                            .setParameter("locat",p.getLocation()).list());
                }
                else {
                    listPark.addAll(getCurrentSession().createQuery("FROM ParkingSpot WHERE nbParking=:nbpark")

                            .setParameter("nbpark",p.getNbParking()).list());
                }
            }
            else {
                if(!p.getLocation().equals("")){

                    System.out.println ("Filtre sur ville");
                    listPark.addAll(getCurrentSession().createQuery("FROM ParkingSpot WHERE  location=:locat").setParameter("locat",p.getLocation()).list());
                }
            }

        }
        /*if (p.getId()!=null){
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
        List<ParkingSpot> listParkcopy=listPark;
        int cpt;
        for (ParkingSpot spot :listPark){
            for (ParkingSpot spotCopy :listParkcopy){
                cpt=0;
                if(spot.equals(spotCopy)){
                    cpt=cpt+1;
                    if (cpt>=2){
                      listParkcopy.remove(spotCopy);
                    }
                }
            }
        }
        listPark=listParkcopy;*/
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
