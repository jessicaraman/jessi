package fr.digicar.dao;

import fr.digicar.model.Delay;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class DelayDAOImpl implements DelayDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Delay> findAll() {
        List<Delay> delays = new ArrayList<Delay>();
        int delayNumber = new Random().nextInt(10000) + 10;
        for (int i = 0; i < delayNumber; i++) {
            delays.add(new Delay());
        }
        return delays;
    }

}
