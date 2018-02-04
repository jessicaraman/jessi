/*
package fr.digicar.backoffice.service;

import fr.digicar.model.Car;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CarServiceNew extends AbstractService<Car, String>{

    public CarServiceNew(){super(Car.class);}

    public List<Car> CarByCriteria(String mark, String name_model, String type, String transmission, String fuel_type){

        String findByCriteriaQueryString = buildFindByCriteriaQuery(mark, name_model, type, transmission, fuel_type);
        TypedQuery<Car> findByCriteriaQuery = getEntityManager().createQuery(findByCriteriaQueryString, Car.class);
        fillFindByCriteriaQuery(findByCriteriaQuery, mark, name_model, type, transmission, fuel_type);

        List<Car> resultList = findByCriteriaQuery.getResultList();

        return resultList;
    }

    private String buildFindByCriteriaQuery(String mark, String name_model, String type, String transmission, String fuel_type){
        StringBuilder query = new StringBuilder("SELECT o FROM Car o WHERE ");

        if (null != mark && !mark.isEmpty()){
            query.append("o.mark = :mark ");
        }
        if (null != name_model && !name_model.isEmpty()){
            query.append("and o.name_model = :name_model ");
        }
        if (null != type && !type.isEmpty()){
            query.append("and o.type = :type ");
        }
        if (null != transmission && !transmission.isEmpty()){
            query.append("and o.transmission = :transmission ");
        }
        if (null != fuel_type && !fuel_type.isEmpty()){
            query.append("and o.fuel_type = :fuel_type ");
        }
        query.append("ORDER BY o.mark ASC ");
        return query.toString();
    }

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

}
*/
