package fr.digicar.dao;

import fr.digicar.model.SessionEnCours;
<<<<<<< HEAD
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

=======
import fr.digicar.model.SessionEnCours;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
>>>>>>> da59a1f040c909ddc8f69e3ab2aa07b992041463
import java.util.ArrayList;
import java.util.List;


@Repository
public class SessionEnCoursDAOImpl implements SessionEnCoursDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addSessionEnCours(SessionEnCours sessionEnCours) {
        getCurrentSession().save(sessionEnCours);
    }

   

    public void updateSessionEnCours(SessionEnCours sessionEnCours) {
        SessionEnCours sessionEnCoursUpdate = getSessionEnCours(sessionEnCours.getIdSession());
<<<<<<< HEAD
        sessionEnCoursUpdate.setTag(sessionEnCours.isTag());
=======
        sessionEnCoursUpdate.setPenality(sessionEnCours.getPenality());
>>>>>>> da59a1f040c909ddc8f69e3ab2aa07b992041463
        getCurrentSession().update(sessionEnCoursUpdate);

    }

    public SessionEnCours getSessionEnCours(int id) {
        return (SessionEnCours) getCurrentSession().get(SessionEnCours.class, id);
    }

    public List<SessionEnCours> getSessionEnCoursByObj(SessionEnCours p) {


        List<SessionEnCours> listRetard=new ArrayList<SessionEnCours>();
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

    public void deleteSessionEnCours(int id) {
        SessionEnCours sessionEnCours = getSessionEnCours(id);
        if (sessionEnCours != null)
            getCurrentSession().delete(sessionEnCours);
    }

    @SuppressWarnings("unchecked")

    public List<SessionEnCours> getSessionsEnCours() {
<<<<<<< HEAD

        List<SessionEnCours> L=getCurrentSession().createQuery("FROM SessionEnCours").list();

        return L;
=======
        return getCurrentSession().createQuery("FROM SessionEnCours").list();
>>>>>>> da59a1f040c909ddc8f69e3ab2aa07b992041463
    }




}
