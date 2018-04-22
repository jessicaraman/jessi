package fr.digicar.backoffice.service;

import fr.digicar.dao.SubscriptionDAO;
import fr.digicar.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionDAO subscriptionDAO;

    @Override
    public void addSubscription(Subscription subscription) {
        subscriptionDAO.addSubscription(subscription);
    }

    @Override
    public void updateSubscription(Subscription subscription) {
        subscriptionDAO.updateSubscription(subscription);
    }

    @Override
    public Subscription getSubscription(int subscriptionId) {
        return subscriptionDAO.getSubscription(subscriptionId);
    }

    @Override
    public List<Subscription> getSubscriptionByUserId() {
        return subscriptionDAO.getSubscriptionByUserID();
    }

    @Override
    public void deleteSubscription(int subscriptionId) { }


}
