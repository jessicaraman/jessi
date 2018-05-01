package fr.digicar.dao;

import fr.digicar.model.CommercialGesture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CommercialeGestureDAOImpl implements CommercialeGestureDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CommercialGesture> getAllCommeercialGesture()  {
        return getCurrentSession().createQuery("FROM CommercialGesture").list();
    };

    @Override
    @SuppressWarnings("unchecked")
    public List<CommercialGesture> getFirstCommercialGestureFree()  {
    List<CommercialGesture> resultList = new ArrayList<>();

    try {
        resultList = getCurrentSession().createQuery("FROM CommercialGesture WHERE id_user = null").list();
    } catch (Exception e) {
    }
    return resultList;
    };

}
