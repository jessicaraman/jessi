package fr.digicar.dao;

import fr.digicar.model.FuelType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FuelTypeDAOImpl implements FuelTypeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addFuelType(FuelType fuelType) {
        getCurrentSession().save(fuelType);
    }

    @SuppressWarnings("unchecked")
    public List<FuelType> getAllFuelType() {
        return getCurrentSession().createQuery("FROM FuelType").list();
    }

}