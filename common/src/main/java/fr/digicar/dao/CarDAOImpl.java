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

}