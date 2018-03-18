package fr.digicar.dao;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import fr.digicar.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


@Repository
public class RetardCalculeDAOImpl implements RetardCalculeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SessionEnCoursDAO sessionEnCoursDAO;

    @Autowired
    private ParkingSpotDAO parkingSpotDAO;


    private ParkingSpot parkingSpot;

    @Autowired
    private UserDAO userDAO;

    private User user;

    @Autowired
    private CarDAO carDAO;

    private Car car;

    @Autowired
    private TarifDAO tarifDAO;

    private Tarif tarif;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addRetardCalcule(RetardCalcule retardCalcule) {
        getCurrentSession().save(retardCalcule);
    }

    public void updateRetardCalcule(RetardCalcule retardCalcule) {
        RetardCalcule retardCalculeUpdate = getRetardCalcule(retardCalcule.getId());
        retardCalculeUpdate.setTagAppel(retardCalcule.getTagAppel());
        getCurrentSession().update(retardCalculeUpdate);

    }

    public RetardCalcule getRetardCalcule(int id) {
        return (RetardCalcule) getCurrentSession().get(RetardCalcule.class, id);
    }

    public List<RetardCalcule> getRetardCalculeByObj(RetardCalcule p) {


        List<RetardCalcule> listRetard = new ArrayList<RetardCalcule>();

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

    public void deleteAllRetardsCalcule() {
        getCurrentSession().createQuery("DELETE FROM RetardCalcule").executeUpdate();
    }


    public void addRetardCalculeAutomatically() throws IOException, JSONException {
        // deleteAllRetardsCalcule();
        List<SessionEnCours> lstSession = sessionEnCoursDAO.getSessionsEnCours();
        float latitudeAct;
        float longitudeAct;
        float latitudeArrive;
        float longitudeArrive;
        String phone, lastName, firstName, model, marque, immat;
        Time arriveCalcule;

        for (SessionEnCours s : lstSession) {
            RetardCalcule retardCalcule = new RetardCalcule();
            parkingSpot = parkingSpotDAO.getParkingSpot(s.getIdPlaceArrivee());
            car = carDAO.getCarById(s.getIdCar());
            user = userDAO.getUser(s.getIdUser());
            tarif=tarifDAO.getTarifsByLibelle("penalite de retard").get(0);
            phone = user.getPhoneNumber();
            lastName = user.getLastName();
            firstName = user.getFirstName();
            model = car.getName_model();
            marque = car.getMark();
            immat = car.getRegistration_number();
            latitudeArrive = parkingSpot.getLatitude();
            longitudeArrive = parkingSpot.getLongitude();
            longitudeAct = s.getLongitudeCurrent();
            latitudeAct = s.getLatitudeCurrent();
            java.util.Date d=new java.util.Date();
            List<Object> l=calculDuration(latitudeAct + "," + longitudeAct, latitudeArrive + "," + longitudeArrive,d);
            arriveCalcule = (Time)l.get(1);
            retardCalcule.setHeureRetourPrevu(new Time(s.getHeureArriveePrevu().getTime()));
            retardCalcule.setFirstName(firstName);
            retardCalcule.setLastName(lastName);
            retardCalcule.setHeureRetourCalcule(arriveCalcule);
            retardCalcule.setIdSession(s.getIdSession());
            retardCalcule.setImmatriculation(immat);
            retardCalcule.setMark(marque);
            retardCalcule.setModel(model);
            retardCalcule.setPhoneNumber(phone);
            retardCalcule.setTagAppel(s.isTag());
            int differenceHeur=(((Time) l.get(1)).getHours()-s.getHeureArriveePrevu().getHours())*60;
            int differenceMin=(((Time) l.get(1)).getMinutes()-s.getHeureArriveePrevu().getMinutes());
            retardCalcule.setPenality((differenceHeur+differenceMin)*(tarif.getPrix_heure()/60));
            getCurrentSession().save(retardCalcule);

        }


    }

    public Time ajouterSeconde(int min, java.util.Date date){
        int temp=date.getHours()*3600+date.getMinutes()*60+date.getSeconds();
        int total =temp+min;
        Time time= new Time(total*1000-3600000);
        return time;
    }

    public List<Object> calculDuration(String origin, String destination, java.util.Date currentTime) throws IOException, JSONException {

        List<Object> l=new ArrayList<Object>();
        final String API_KEY = "AIzaSyBlCPYWn72s0pPLrZxVYBzwQcRlk2cwfAs";
        OkHttpClient client = new OkHttpClient();
        //https://maps.googleapis.com/maps/api/distancematrix/json?origins=48,28&destinations=48,27&language=fr-FR&key=AIzaSyBlCPYWn72s0pPLrZxVYBzwQcRlk2cwfAs
        String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origin + "&destinations=" + destination + "&language=fr-FR&key=" + API_KEY;
        Request request = new Request.Builder().url(url_request).build();

        try {
            Response response = client.newCall(request).execute();
            JSONObject obj = new JSONObject(response.body().string());
            int time = (Integer) obj.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("duration").get("value");
            l.add(time/60);
            l.add(ajouterSeconde(time,currentTime));
            return l;

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }


    }

}
