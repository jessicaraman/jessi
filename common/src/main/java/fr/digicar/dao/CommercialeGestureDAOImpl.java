package fr.digicar.dao;

import fr.digicar.model.CommercialGesture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CommercialeGestureDAOImpl implements CommercialeGestureDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CommercialGesture> getAllCommeercialGesture()  {
        return getCurrentSession().createQuery("FROM CommercialGesture").list();
    };

    @Override
    @SuppressWarnings("unchecked")
    public List<CommercialGesture> getFirstCommercialGestureFree()  {
        List<CommercialGesture> resultList = new ArrayList<>();

        try {
            resultList = getCurrentSession().createQuery("FROM CommercialGesture WHERE id_user = null").list();
        } catch (Exception e) {
        }
        return resultList;
    }

    @Override
    public void updateCommercialGestureForUser(int id_user, String code){

        String weeks2="";
        Date today = new Date();

        try {

            List<CommercialGesture> resultList;
            resultList = getCurrentSession().createQuery("FROM CommercialGesture WHERE code = '"+code+"'").list();

            CommercialGesture commercialGesture = new CommercialGesture();
            commercialGesture.setId(resultList.get(0).getId());
            commercialGesture.setId_user(id_user);
            commercialGesture.setCode(resultList.get(0).getCode());
            commercialGesture.setValeur(resultList.get(0).getValeur());

            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                weeks2 = sdfDate.format(today.getTime() + (1000 * 60 * 60 * 24*14));

                commercialGesture.setDate_fin_validite(Timestamp.valueOf(weeks2));
                getCurrentSession().update(commercialGesture);
            }catch (Exception e){}


        } catch (Exception e) {
            //log.error("Error when updating Car.", e);
        }
    }

}
