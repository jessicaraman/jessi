package fr.digicar.dao;

import fr.digicar.model.Subscription;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Slf4j
@Repository
public class SubscriptionDAOImpl implements SubscriptionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addSubscription(Subscription subscription) {
        getCurrentSession().save(subscription);
    }

    @Override
    public void updateSubscription(Subscription subscription) {
        Subscription SubscriptionUpdate = getSubscription(subscription.getId());
        SubscriptionUpdate.setEndDate(new Date());
        getCurrentSession().update(SubscriptionUpdate);
    }

    @Override
    public Subscription getSubscription(int subscriptionId) {
        Session session = this.sessionFactory.getCurrentSession();
        return (Subscription) session.load(Subscription.class, subscriptionId);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Subscription> getSubscriptionByUserID() {
        int day = new Date().getDate();
        String sql = "FROM Subscription WHERE endDate IS NULL and startDate LIKE '%" + day + "' GROUP BY user";
        log.debug(sql);
        return getCurrentSession().createQuery(sql).list();
    }

    public void deleteSubscription(int subscriptionId) { }

    public List<Subscription> getSubscriptions() {
        return null;
    }


    public List<Subscription> SubscriptionsByDate(Date date) {
        return null;
    }

}
