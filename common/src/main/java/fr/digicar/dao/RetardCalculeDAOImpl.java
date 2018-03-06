package fr.digicar.dao;

import fr.digicar.model.RetardCalcule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RetardCalculeDAOImpl implements RetardCalculeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addRetardCalcule(RetardCalcule retardCalcule) {
        getCurrentSession().save(retardCalcule);
    }

    public void updateRetardCalcule(RetardCalcule retardCalcule) {
        RetardCalcule retardCalculeUpdate = getRetardCalcule(retardCalcule.getId());
        retardCalculeUpdate.setHeureRetourPrevu(retardCalcule.getHeureRetourPrevu());
        getCurrentSession().update(retardCalculeUpdate);

    }

    public RetardCalcule getRetardCalcule(int id) {
        return (RetardCalcule) getCurrentSession().get(RetardCalcule.class, id);
    }

    public List<RetardCalcule> getRetardCalculeByObj(RetardCalcule p) {


        List<RetardCalcule> listRetard=new ArrayList<RetardCalcule>();
        /*System.out.println(p.getNbSpot()+" place "+p.getLocation()+" VILLE  "+p.getNbParking()+" parking");
        System.out.println((p.getNbSpot()!=null) +"/"+ !p.getNbParking().equals("")+"/"+!p.getLocation().equals(""));



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

        }*/
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
        return listRetard;
    }

    public void deleteRetardCalcule(int id) {
        RetardCalcule retardCalcule = getRetardCalcule(id);
        if (retardCalcule != null)
            getCurrentSession().delete(retardCalcule);
    }

    @SuppressWarnings("unchecked")

    public List<RetardCalcule> getRetardsCalcule() {
        return getCurrentSession().createQuery("FROM RetardCalcule").list();
    }

}
