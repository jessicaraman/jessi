package fr.digicar.dao;

import fr.digicar.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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


    }

    public Car getCar(String registration_number) {
        return (Car) getCurrentSession().get(Car.class, registration_number);
    }

    public void deleteCar(String registration_number) {
        Car car = getCar(registration_number);
        if (car != null)
            getCurrentSession().delete(car);
    }


    @SuppressWarnings("unchecked")
    public List<Car> getAllCar() {
        return getCurrentSession().createQuery("FROM car").list();
    }

}