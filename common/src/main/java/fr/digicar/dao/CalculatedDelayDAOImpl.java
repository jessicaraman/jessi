package fr.digicar.dao;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import fr.digicar.model.*;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Slf4j
@Repository
public class CalculatedDelayDAOImpl implements CalculatedDelayDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CurrentSessionDAO currentSessionDAO;

    @Autowired
    private ParkingSpotDAO parkingSpotDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private CarDAO carDAO;

    @Autowired
    private PricingDAO pricingDAO;

    private static String actualTime;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCalculatedDelay(CalculatedDelay calculatedDelay) {
        getCurrentSession().save(calculatedDelay);
    }

    @Override
    public void updateCalculatedDelay(CalculatedDelay calculatedDelay) {
        CalculatedDelay updatedCalculatedDelay = getCalculatedDelayById(calculatedDelay.getId());
        updatedCalculatedDelay.setTagAppel(calculatedDelay.isTagAppel());
        getCurrentSession().update(updatedCalculatedDelay);
    }

    @Override
    public CalculatedDelay getCalculatedDelayById(int id) {
        return (CalculatedDelay) getCurrentSession().get(CalculatedDelay.class, id);
    }

    @Override
    public List<CalculatedDelay> getCalculatedDelaysByObj(CalculatedDelay p) {
        return new ArrayList<>();
    }

    @Override
    public void deleteCalculatedDelay(int id) {
        CalculatedDelay calculatedDelay = getCalculatedDelayById(id);
        if (calculatedDelay != null)
            getCurrentSession().delete(calculatedDelay);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CalculatedDelay> getCalculatedDelays() {
        return getCurrentSession().createQuery("FROM CalculatedDelay").list();
    }

    @Override
    public void deleteAllCalculatedDelays() {
        getCurrentSession().createQuery("DELETE FROM CalculatedDelay").executeUpdate();
    }

    @Override
    public void addCalculatedDelaysAutomatically() throws IOException, JSONException {
        // deleteAllCalculatedDelays();
        List<CurrentSession> lstSession = currentSessionDAO.getCurrentSessions();
        float latitudeAct;
        float longitudeAct;
        float latitudeArrive;
        float longitudeArrive;
        String phone, lastName, firstName, model, brand, registrationNumber;
        Time calculatedArrivalTime;

        for (CurrentSession s : lstSession) {
            CalculatedDelay calculatedDelay = new CalculatedDelay();
            ParkingSpot parkingSpot = parkingSpotDAO.getParkingSpot(s.getArrivalParkingSpot());
            Car car = carDAO.getCarById(s.getCar());
            User user = userDAO.getUser(s.getUser());
            Pricing pricing = pricingDAO.getPricingsByLabel("penalite de retard").get(0);
            phone = user.getPhoneNumber();
            lastName = user.getLastName();
            firstName = user.getFirstName();
            model = car.getModelName();
            brand = car.getBrandName();
            registrationNumber = car.getRegistrationNumber();
            latitudeArrive = parkingSpot.getLatitude();
            longitudeArrive = parkingSpot.getLongitude();
            longitudeAct = s.getLongitudeCurrent();
            latitudeAct = s.getLatitudeCurrent();
            Date d = new Date();
            List<Object> l = calculateDuration(latitudeAct + "," + longitudeAct, latitudeArrive + "," + longitudeArrive, d);
            calculatedArrivalTime = (Time) l.get(1);
            calculatedDelay.setExpectedReturnTime(new Time(s.getExpectedArrivalTime().getTime()));
            calculatedDelay.setFirstName(firstName);
            calculatedDelay.setLastName(lastName);
            calculatedDelay.setCalculatedReturnTime(calculatedArrivalTime);
            calculatedDelay.setIdSession(s.getId());
            calculatedDelay.setRegistrationNumber(registrationNumber);
            calculatedDelay.setBrand(brand);
            calculatedDelay.setModel(model);
            calculatedDelay.setPhoneNumber(phone);
            calculatedDelay.setTagAppel(s.isTag());
            int hourDiff = (((Time) l.get(1)).getHours() - s.getExpectedArrivalTime().getHours()) * 60;
            int minuteDiff = (((Time) l.get(1)).getMinutes() - s.getExpectedArrivalTime().getMinutes());
            calculatedDelay.setPenality((hourDiff + minuteDiff) * (pricing.getHourlyPrice() / 60));
            //to have a datetime format
            calculatedDelay.setCalculatedReturnDateTime(Timestamp.valueOf(actualTime));
            getCurrentSession().save(calculatedDelay);
        }
    }

    private Time addSecond(int min, java.util.Date date) {
        int temp = date.getHours() * 3600 + date.getMinutes() * 60 + date.getSeconds();
        int total = temp + min;
        return new Time(total * 1000 - 3600000);
    }

    private List<Object> calculateDuration(String origin, String destination, java.util.Date currentTime) throws IOException, JSONException {
        List<Object> l = new ArrayList<>();
        final String API_KEY = "AIzaSyBlCPYWn72s0pPLrZxVYBzwQcRlk2cwfAs";
        OkHttpClient client = new OkHttpClient();
        // https://maps.googleapis.com/maps/api/distancematrix/json?origins=48,28&destinations=48,27&language=fr-FR&key=AIzaSyBlCPYWn72s0pPLrZxVYBzwQcRlk2cwfAs
        final String URL_REQUEST = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origin + "&destinations=" + destination + "&language=fr-FR&key=" + API_KEY;
        Request request = new Request.Builder().url(URL_REQUEST).build();

        try {
            Response response = client.newCall(request).execute();
            JSONObject obj = new JSONObject(response.body().string());
            int time = (Integer) obj.getJSONArray("rows")
                    .getJSONObject(0)
                    .getJSONArray("elements")
                    .getJSONObject(0)
                    .getJSONObject("duration")
                    .get("value");
            l.add(time / 60);
            l.add(addSecond(time, currentTime));

            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                actualTime = sdfDate.format(currentTime);
            }catch (Exception e){}


            return l;
        } catch (IOException e) {
            log.error("Error when during trip duration calculation.", e);
            throw new IOException(e.getMessage(), e);
        }
    }

}
