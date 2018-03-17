package fr.digicar.dao;

import fr.digicar.model.Car;
import fr.digicar.model.Subscription;

import java.util.Date;
import java.util.List;

public interface SubscriptionDAO {

    void addSubscription(Subscription sub);
    void updateSubscription(Subscription subscription);
    Subscription getSubscription(int SubscriptionId);
    List<Subscription> getSubscriptionByUserID(Integer id_user);
    void deleteSubscription(int SubscriptionId);
    List<Subscription> getSubscriptions();
    List<Subscription> SubscriptionsByDate(Date d);
}
