package fr.digicar.backoffice.service;

import fr.digicar.dao.SubscriptionDAO;
import fr.digicar.model.Invoice;
import fr.digicar.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionDAO subscriptionDAO;
    @Override
    public void addSubscription(Subscription sub) {
        subscriptionDAO.addSubscription(sub);
    }

    @Override
    public void updateSubscription(Subscription subscription) {
        subscriptionDAO.updateSubscription(subscription);

    }

    @Override
    public Subscription getSubscription(int SubscriptionId) {
        return subscriptionDAO.getSubscription(SubscriptionId);
    }

    @Override
    public List<Subscription> getSubscriptionByUserID() {
        return subscriptionDAO.getSubscriptionByUserID();
    }

    @Override
    public void deleteSubscription(int SubscriptionId) {


    }


}
