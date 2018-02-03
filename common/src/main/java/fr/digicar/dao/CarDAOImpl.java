package fr.digicar.dao;

import fr.digicar.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

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

        getCurrentSession().update(car);

    }

    public Car getCar(int carId) {

        return (Car) getCurrentSession().get(Car.class, carId);
    }

    public void deleteCar(int carId) {
        Car car = (Car) getCurrentSession().load(Car.class, carId);
        if (car != null)
            getCurrentSession().delete(car);
    }


    @SuppressWarnings("unchecked")
    public List<Car> getCars() {
        return getCurrentSession().createQuery("FROM Car").list();
    }


    public List<Car> CarByCriteria(String mark, String name_model, String type, String transmission, String fuel_type){

        String findByCriteriaQueryString = buildFindByCriteriaQuery(mark, name_model, type, transmission, fuel_type);

        List<Car> resultList = getCurrentSession().createQuery(findByCriteriaQueryString).list();

        return resultList;
    }

    private String buildFindByCriteriaQuery(String mark, String name_model, String type, String transmission, String fuel_type){
        String query = new String("FROM Car WHERE");

        if (null != mark && !mark.isEmpty()){
            query += query+" mark = "+mark;
        }
        if (null != name_model && !name_model.isEmpty()){
            query += query+" and name_model = "+name_model;
        }
        if (null != type && !type.isEmpty()){
            query = query+" and type = "+type;
        }
        if (null != transmission && !transmission.isEmpty()){
            query = query+" and transmission = "+transmission;
        }
        if (null != fuel_type && !fuel_type.isEmpty()){
            query = query+" and fuel_type = "+fuel_type ;
        }
        query += query+" ORDER BY o.mark ASC ";
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