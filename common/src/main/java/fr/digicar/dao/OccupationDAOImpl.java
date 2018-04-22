package fr.digicar.dao;

import fr.digicar.model.Occupation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class OccupationDAOImpl implements OccupationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Occupation getOccupationById(int idOccupation) {
        return (Occupation) getCurrentSession().get(Occupation.class, idOccupation);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Occupation> getAllOccupations() {
        return getCurrentSession().createQuery("FROM Occupation").list();
    }

  /*  private String buildFindByCriteriaQuery(String mark, String name_model, String type, String transmission, String fuel_type, String mileageMin, String mileageMax){
        String query = new String("FROM Car WHERE");
        String querypParam = "";
        if (null != mark && !mark.isEmpty()){
            querypParam += " mark = '"+mark+"'";
        }
        if (null != name_model && !name_model.isEmpty()){
            querypParam += " and name_model = '"+name_model+"'";
        }
        if (null != type && !type.isEmpty()){
            querypParam += " and type = '"+type+"'";
        }
        if (null != transmission && !transmission.isEmpty()){
            querypParam += " and transmission = '"+transmission+"'";
        }
        if (null != fuel_type && !fuel_type.isEmpty()){
            querypParam += " and fuel_type = '"+fuel_type+"'" ;
        }

        if (null != mileageMin && !mileageMin.isEmpty() && null !=mileageMax && !mileageMax.isEmpty() ){
            querypParam += " and kilometers between "+mileageMin+" and "+mileageMax ;
        }
        querypParam += " ORDER BY mark ASC ";
        query += querypParam;
        return query;
    }*/
}