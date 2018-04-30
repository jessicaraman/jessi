package fr.digicar.backoffice.service;

import fr.digicar.model.Car;
import fr.digicar.model.Session;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface SessionService {

    Session getSession(int id);

    List<Session> getUserSessions(int userID, Date d);

    void removeSessionById(int id);

    void updateSessionById(int sessionId, int carId);

    Car getSessionCar(int sessionId);

}
