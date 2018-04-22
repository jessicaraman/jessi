package fr.digicar.dao;

import fr.digicar.model.Subscription;

import java.util.Date;
import java.util.List;

public interface SubscriptionDAO {

    void addSubscription(Subscription subscription);

    void updateSubscription(Subscription subscription);

    Subscription getSubscription(int subscriptionId);

    /**
     * Gets users to invoice on the current day.
     *
     * @return the list of corresponding subscriptions.
     */
    List<Subscription> getSubscriptionByUserId();

    void deleteSubscription(int subscriptionId);

    List<Subscription> getSubscriptions();

    List<Subscription> subscriptionsByDate(Date date);

}
