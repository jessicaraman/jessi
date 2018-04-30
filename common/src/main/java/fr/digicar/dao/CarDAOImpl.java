package fr.digicar.dao;

import fr.digicar.model.Car;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class CarDAOImpl implements CarDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCar(Car car) {
        getCurrentSession().save(car);
    }

    @Override
    public void updateCar(Car car) {
        try {
            getCurrentSession().update(car);
        } catch (JDBCException e) {
            log.error("Error when updating Car.", e);
        }
    }

    @Override
    public Car getCarById(int carId) {
        return (Car) getCurrentSession().get(Car.class, carId);
    }

    //pas branchée encore
    @Override
    public Car getCarByRegistration(String registration) {
        List<Car> list;

        Car car = new Car();
        try {
            list = getCurrentSession().createQuery("FROM Car WHERE registrationNumber = '" + registration + "'").list();
            car = null != list && !list.isEmpty() ? list.get(0) : null;
        } catch (JDBCException e) {
            log.error("Error when getting Car by registration number.", e);
        }
        return car;
    }

    @Override
    public void deleteCar(int carId) {
        try {
            Car car = (Car) getCurrentSession().load(Car.class, carId);
            if (car != null)
                getCurrentSession().delete(car);
        } catch (JDBCException e) {
            log.error("Error when deleting Car " + carId, e);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getAllCar() {
        return getCurrentSession().createQuery("FROM Car").list();
    }

    @Override
    public List<Car> carByCriteria(String brandName, String modelName, String type, String transmission, String fuelType, String mileageMin, String mileageMax) {
        String findByCriteriaQueryString = buildFindByCriteriaQuery(brandName, modelName, type, transmission, fuelType, mileageMin, mileageMax);

        List<Car> resultList = new ArrayList<>();
        try {
            resultList = getCurrentSession().createQuery(findByCriteriaQueryString).list();
        } catch (JDBCException e) {
            log.error("Error when updating Car.", e);
        }

        return resultList;
    }

    private String buildFindByCriteriaQuery(String mark, String modelName, String type, String transmission, String fuelType, String mileageMin, String mileageMax) {
        String query = "FROM Car WHERE";
        String querypParam = "";
        if (null != mark && !mark.isEmpty()) {
            querypParam += " brandName = '" + mark + "'";
        }
        if (null != modelName && !modelName.isEmpty()) {
            querypParam += " AND modelName = '" + modelName + "'";
        }
        if (null != type && !type.isEmpty()) {
            querypParam += " AND type = '" + type + "'";
        }
        if (null != transmission && !transmission.isEmpty()) {
            querypParam += " AND transmission = '" + transmission + "'";
        }
        if (null != fuelType && !fuelType.isEmpty()) {
            querypParam += " AND fuelType = '" + fuelType + "'";
        }

        if (null != mileageMin && !mileageMin.isEmpty() && null != mileageMax && !mileageMax.isEmpty()) {
            querypParam += " AND kilometers BETWEEN " + mileageMin + " AND " + mileageMax;
        }
        querypParam += " ORDER BY mark ASC ";
        query += querypParam;
        return query;
    }

}