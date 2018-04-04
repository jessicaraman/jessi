package fr.digicar.backoffice.emergency_modification.service;

import fr.digicar.dao.SessionEnCoursDAO;
import fr.digicar.model.SessionEnCours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SessionEnCoursServiceImpl implements SessionEnCoursService {

    @Autowired
    private SessionEnCoursDAO sessionEnCoursDAO;

    @Override
    public void addSessionEnCours(SessionEnCours sessionEnCours) {
        sessionEnCoursDAO.addSessionEnCours(sessionEnCours);
    }



    @Override
    public void updateSessionEnCours(SessionEnCours sessionEnCours) {
        sessionEnCoursDAO.updateSessionEnCours(sessionEnCours);
    }

    @Override
    public SessionEnCours getSessionEnCours(int id) {
        return sessionEnCoursDAO.getSessionEnCours(id);
    }

    @Override
    public void deleteSessionEnCours(int id) {
        sessionEnCoursDAO.deleteSessionEnCours(id);
    }

    @Override
    public List<SessionEnCours> getSessionsEnCours() {
        return sessionEnCoursDAO.getSessionsEnCours();
    }

    @Override
    public List<SessionEnCours> getSessionEnCoursByObj(SessionEnCours p) {
        return sessionEnCoursDAO.getSessionEnCoursByObj(p);
    }

}
