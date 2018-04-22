package fr.digicar.dao;

import fr.digicar.model.TransmissionMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransmissionModeDAOImpl implements TransmissionModeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addTransmissionMode(TransmissionMode transmissionMode) {
        getCurrentSession().save(transmissionMode);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TransmissionMode> getAllTransmissionMode() {
        return getCurrentSession().createQuery("FROM TransmissionMode").list();
    }

}