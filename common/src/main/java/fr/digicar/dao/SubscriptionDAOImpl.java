package fr.digicar.dao;

import fr.digicar.model.Subscription;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class SubscriptionDAOImpl implements  SubscriptionDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addSubscription(Subscription subscription) {
        getCurrentSession().save(subscription);
    }


    public void updateSubscription(Subscription subscription) {
        Subscription SubscriptionUpdate = getSubscription(subscription.getId());

        SubscriptionUpdate.setEnd_date(new Date());

        getCurrentSession().update(SubscriptionUpdate);
    }



    public  Subscription getSubscription(int SubscriptionId) {
        Session session = this.sessionFactory.getCurrentSession();
        Subscription t = (Subscription) session.load(Subscription.class, new Integer(SubscriptionId));
        return t;
    }

    //Récupère les utilisateurs à facturer le jour
    public List<Subscription> getSubscriptionByUserID() {
        int day=new Date().getDate();
        String sql ="FROM Subscription where end_date is null and start_date like '%"+day+"' group by id_user";
        System.out.println(sql);
        return getCurrentSession().createQuery(sql).list();
    }

    public void deleteSubscription(int SubscriptionId) {

    }

    public List<Subscription> getSubscriptions() {
        return null;
    }


    public List<Subscription> SubscriptionsByDate(Date d) {
        return null;
    }

}
