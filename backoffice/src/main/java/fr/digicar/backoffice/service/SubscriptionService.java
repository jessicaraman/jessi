package fr.digicar.backoffice.service;

import fr.digicar.model.Invoice;
import fr.digicar.model.Subscription;

import java.util.Date;
import java.util.List;

public interface SubscriptionService {
    void addSubscription(Subscription sub);
    void updateSubscription(Subscription subscription);
    Subscription getSubscription(int SubscriptionId);
    List<Subscription> getSubscriptionByUserID();
    void deleteSubscription(int SubscriptionId);

    //List<Subscription> SubscriptionByCriteria(Integer ids, Integer id_u, Integer id_p, Date start_d, Date end_d);
}
