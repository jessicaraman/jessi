package fr.digicar.dao;

import fr.digicar.model.CarAvailability;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class CarAvailabilityDAOImpl implements CarAvailabilityDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public CarAvailability getCarAvailabilityByCriteria(String available) {

        List<CarAvailability> list;

        CarAvailability carAvailability = new CarAvailability();
        try {
            list = getCurrentSession().createQuery("FROM car_availability WHERE available = '"+available+"'").list();

            carAvailability = (!list.isEmpty() && list != null) ? list.get(0) : null;

        } catch (JDBCException e) {
            log.error("Error.", e);
        }
        return carAvailability;
    }

    @Override
    public List<CarAvailability> getAllCarAvailabilities() {
        return getCurrentSession().createQuery("FROM car_availability WHERE available = 'yes'").list();
    }


}
