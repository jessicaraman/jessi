package fr.digicar.dao;

import fr.digicar.model.CarType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarTypeDAOImpl implements CarTypeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addCarType(CarType carType) {
        getCurrentSession().save(carType);
    }

    @SuppressWarnings("unchecked")
    public List<CarType> getAllCarType() {
        return getCurrentSession().createQuery("FROM CarType").list();
    }

}