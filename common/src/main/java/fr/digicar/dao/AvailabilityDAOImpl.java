package fr.digicar.dao;

import fr.digicar.model.Availability;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AvailabilityDAOImpl implements AvailabilityDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    public Availability getAvailabilityById(int availabilityId) {

        return (Availability) getCurrentSession().get(Availability.class, availabilityId);
    }

    public List<Availability> getAllAvailability() {
        return getCurrentSession().createQuery("FROM Availability where status = true").list();
    }


    public List<Availability> availabilityByCriteria(String date, String start_time, String end_time){

        String findByCriteriaQueryString = buildFindByCriteriaQuery(date, start_time, end_time);

        List<Availability> resultList = new ArrayList<Availability>();
        try{
            resultList = getCurrentSession().createQuery(findByCriteriaQueryString).list();
        }
        catch(JDBCException e) {
            //Error during hibernate query
        }

        return resultList;
    }

    private String buildFindByCriteriaQuery(String date, String start_time, String end_time){
        String query = new String("FROM Availability where status = true");
        String querypParam = "";
        if (null != date ){
            querypParam += " and date = '"+date+"'";
        }
        if (null != start_time){
            querypParam += " and start_time <= '"+start_time+"'";
        }
        if (null != end_time){
            querypParam += " and end_time >= '"+end_time+"'";
        }

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