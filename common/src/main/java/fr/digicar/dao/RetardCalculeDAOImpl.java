package fr.digicar.dao;

import fr.digicar.model.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.Minutes;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.google.maps.*;
import com.google.maps.model.GeocodingResult;


@Repository
public class RetardCalculeDAOImpl implements RetardCalculeDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private SessionEnCoursDAO sessionEnCoursDAO;
    private ParkingSpotDAO parkingSpotDAO;
    private ParkingSpot parkingSpot;
    private UserDAO userDAO;
    private User user;
    private CarDAO carDAO;
    private Car car;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addRetardCalcule(RetardCalcule retardCalcule) {
        getCurrentSession().save(retardCalcule);
    }

    public void addRetardCalculeAutomatically() throws IOException, JSONException {
       // getCurrentSession().createQuery("DELETE FROM RetardCalcule");
        RetardCalcule retardCalcule=new RetardCalcule();
        List<SessionEnCours> lstSession= sessionEnCoursDAO.getSessionsEnCours();
        int latitudeAct, longitudeAct,latitudeArrive,longitudeArrive;
        String phone,lastName,firstName,model,marque,immat;
        Date arriveCalcule;

        for(SessionEnCours s : lstSession){
            parkingSpot=parkingSpotDAO.getParkingSpot(s.getIdPlaceDepart());
            car=carDAO.getCarById(s.getIdCar());
            user=userDAO.getUser(s.getIdUser());
            phone=user.getPhoneNumber();
            lastName=user.getLastName();
            firstName=user.getFirstName();
            model=car.getName_model();
            marque=car.getMark();
            immat=car.getRegistration_number();
            latitudeArrive=parkingSpot.getLatitude();
            longitudeArrive=parkingSpot.getLongitude();
            longitudeAct=s.getLongitudeCurrent();
            latitudeAct=s.getLatitudeCurrent();
            arriveCalcule=calculDuration(latitudeAct+","+longitudeAct,latitudeArrive+","+longitudeArrive,new Date(System.currentTimeMillis()));
            retardCalcule.setHeureRetourPrevu(s.getHeureArriveePrevu());
            retardCalcule.setFirstName(firstName);
            retardCalcule.setLastName(lastName);
            retardCalcule.setHeureRetourCalcule(arriveCalcule);
            retardCalcule.setIdSession(s.getIdSession());
            retardCalcule.setImmatriculation(immat);
            retardCalcule.setMark(marque);
            retardCalcule.setModel(model);
            retardCalcule.setPhoneNumber(phone);
            retardCalcule.setTagAppel(false);
            retardCalcule.setPenality(10);//A AJOUTER
            getCurrentSession().save(retardCalcule);

        }


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

    public Date calculDuration(String origin, String destination,Date currentTime) throws IOException, JSONException {

        try {
            final String API_KEY = "AIzaSyD4A9Bz1IVn50gnegr_ct0t01gIypPPu_U";
        OkHttpClient client = new OkHttpClient();
        String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origin + "&destinations=" + destination + "&language=fr-FR&key=" + API_KEY;
        Request request = new Request.Builder().url(url_request).build();
        Response response = client.newCall(request).execute();
        JSONObject obj = new JSONObject(response.body().string());

        int time = (Integer) obj.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("duration").get("value");

        currentTime.setTime(currentTime.getTime()+time);
        return currentTime;}
        catch (IOException e){
            System.out.println("L'erreur est la suivante : "+e);
            throw e;
        }

    }



}
