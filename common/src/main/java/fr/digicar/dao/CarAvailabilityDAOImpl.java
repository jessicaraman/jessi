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

        CarAvailability carAvailability = null;
        try {
            list = getCurrentSession().createQuery("FROM CarAvailability WHERE available = '"+available+"'").list();

            carAvailability = (!list.isEmpty() && list != null) ? list.get(0) : null;

        } catch (JDBCException e) {
            log.error("Error.", e);
        }
        return carAvailability;
    }

    @Override
    public List<CarAvailability> getCarAvailabilityBy(String location, int idCarType) {
        String sql = "FROM CarAvailability join Car WHERE available = 'yes' " +
                     "and id_car = id and  type_id = "+idCarType+
                     " id_parking_spots in (select nbParking from ParkingSpot where location ='"+location+"')";

        return getCurrentSession().createQuery(sql).list();
    }

    @Override
    public List<CarAvailability> getAllCarAvailabilities() {
        return getCurrentSession().createQuery("FROM CarAvailability WHERE available = 'yes'").list();
    }

    @Override
    public void updateCarAvailabilityId(int idCar, String state) {

        try
        {
            String sqlQuery = "UPDATE CarAvailability SET available ='"+state+"'  WHERE id_car='"+idCar+"'";

            getCurrentSession().createSQLQuery(sqlQuery).executeUpdate();

            getCurrentSession().beginTransaction().commit();
            //voir si c'est bien modifié dans booking

        }
        catch(Exception e){
            //Error during hibernate query
        }

    }


}
