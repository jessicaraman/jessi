package fr.digicar.dao;

import fr.digicar.model.Pricing;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class PricingDAOImpl implements PricingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addPricing(Pricing pricing) {
        sessionFactory.getCurrentSession().save(pricing);
    }

    @Override
    public void updatePricing(Pricing pricing) {
        sessionFactory.getCurrentSession().update(pricing);
    }

    @Override
    public Pricing getPricing(int id) {
        return (Pricing) getCurrentSession().get(Pricing.class, id);
    }

    @Override
    public void deletePricing(int id) {
        Pricing pricing = getPricing(id);
        if (pricing != null)
            getCurrentSession().delete(pricing);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Pricing> getPricings() {
        return getCurrentSession().createQuery("FROM Pricing").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Pricing> getPricingsByLabel(String label) {
        String sql = "FROM Pricing";
        if (!label.equals("none")) {
            sql = sql + " WHERE label = '" + label + "'";
        }
        return getCurrentSession().createQuery(sql).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Pricing> searchPricings(String label, float minKmPrice, float maxKmPrice, float minHourlyPrice, float maxHourlyPrice, int minMonthlyFees, int maxMonthlyFees) {
        String sql = "FROM Pricing";
        if (!label.equals("none")) {
            sql = sql + " WHERE label = '" + label + "'";
        } else {
            sql = sql + " where kmPrice >= " + minKmPrice + " AND kmPrice <= " + maxKmPrice +
                    " and hourlyPrice >= " + minHourlyPrice + " AND hourlyPrice <= " + maxHourlyPrice +
                    " and montlyFees >= " + minMonthlyFees + " and montlyFees <= " + maxMonthlyFees;
        }
        log.debug(sql);
        return getCurrentSession().createQuery(sql).list();
    }


}