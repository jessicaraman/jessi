package fr.digicar.backoffice.service;

import fr.digicar.model.Subscription;

import java.util.List;

public interface SubscriptionService {

    void addSubscription(Subscription subscription);

    void updateSubscription(Subscription subscription);

    Subscription getSubscription(int subscriptionId);

    List<Subscription> getSubscriptionByUserId();

    void deleteSubscription(int subscriptionId);

    // List<Subscription> SubscriptionByCriteria(Integer ids, Integer id_u, Integer id_p, Date start_d, Date end_d);
}
