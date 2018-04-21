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

    public void addCar(Car car) {
        getCurrentSession().save(car);
    }

    public void updateCar(Car car) {
        try {
            getCurrentSession().update(car);
        } catch (JDBCException e) {
            log.error("Error when updating Car.", e);
        }
    }

    public Car getCarById(int carId) {
        return (Car) getCurrentSession().get(Car.class, carId);
    }

    //pas branchée encore
    public Car getCarByRegistration(String registration) {
        List<Car> list;

        Car car = new Car();
        try {
            list = getCurrentSession().createQuery("FROM Car WHERE registration_number = '" + registration + "'").list();
            car = null != list && !list.isEmpty() ? list.get(0) : null;
        } catch (JDBCException e) {
            log.error("Error when getting Car by registration number.", e);
        }
        return car;
    }

    public void deleteCar(int carId) {
        try {
            Car car = (Car) getCurrentSession().load(Car.class, carId);
            if (car != null)
                getCurrentSession().delete(car);
        } catch (JDBCException e) {
            log.error("Error when deleting Car " + carId, e);
        }

    }


    @SuppressWarnings("unchecked")
    public List<Car> getAllCar() {
        return getCurrentSession().createQuery("FROM Car").list();
    }


    public List<Car> carByCriteria(String brandName, String modelName, String type, String transmission, String fuelType, String mileageMin, String mileageMax) {
        String findByCriteriaQueryString = buildFindByCriteriaQuery(brandName, modelName, type, transmission, fuelType, mileageMin, mileageMax);

        List<Car> resultList = new ArrayList<Car>();
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
            querypParam += " mark = '" + mark + "'";
        }
        if (null != modelName && !modelName.isEmpty()) {
            querypParam += " and modelName = '" + modelName + "'";
        }
        if (null != type && !type.isEmpty()) {
            querypParam += " and type = '" + type + "'";
        }
        if (null != transmission && !transmission.isEmpty()) {
            querypParam += " and transmission = '" + transmission + "'";
        }
        if (null != fuelType && !fuelType.isEmpty()) {
            querypParam += " and fuelType = '" + fuelType + "'";
        }

        if (null != mileageMin && !mileageMin.isEmpty() && null != mileageMax && !mileageMax.isEmpty()) {
            querypParam += " and kilometers between " + mileageMin + " and " + mileageMax;
        }
        querypParam += " ORDER BY mark ASC ";
        query += querypParam;
        return query;
    }
/*
    private void fillFindByCriteriaQuery(Query query, String mark, String name_model, String type, String transmission, String fuel_type){

        if (null != mark && !mark.isEmpty()){
            query.setParameter("mark", mark);
        }
        if (null != name_model && !name_model.isEmpty()){
            query.setParameter("name_model", name_model);
        }
        if (null != type && !type.isEmpty()){
            query.setParameter("type", type);
        }
        if (null != transmission && !transmission.isEmpty()){
            query.setParameter("transmission", transmission);
        }
        if (null != fuel_type && !fuel_type.isEmpty()){
            query.setParameter("fuel_type", fuel_type);
        }
    }
*/
}