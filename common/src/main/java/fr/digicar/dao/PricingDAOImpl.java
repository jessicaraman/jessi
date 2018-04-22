package fr.digicar.dao;

import fr.digicar.model.Pricing;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PricingDAOImpl implements PricingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addTarif(Pricing pricing) {
        sessionFactory.getCurrentSession().save(pricing);

    }

    @Override
    public void updateTarif(Pricing pricing) {
        sessionFactory.getCurrentSession().update(pricing);
    }

    @Override
    public Pricing getTarif(int id) {
        return (Pricing) getCurrentSession().get(Pricing.class, id);
    }

    public Pricing getTarifby(int id) {
        return (Pricing) getCurrentSession().get(Pricing.class, id);
    }

    @Override
    public void deleteTarif(int id) {
        Pricing pricing = getTarif(id);
        if (pricing != null)
            getCurrentSession().delete(pricing);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Pricing> getTarifs() {
        return getCurrentSession().createQuery("FROM Pricing").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Pricing> getTarifsByLibelle(String label) {
        String sql = "FROM Pricing";
        if (!label.equals("none")) {
            sql = sql + " WHERE label = '" + label + "'";
        }
        return getCurrentSession().createQuery(sql).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Pricing> searchTarifs(String label, float minKmPrice, float maxKmPrice, float minHourlyPrice, float maxHourlyPrice, int minMonthlyFees, int maxMonthlyFees) {
        String sql = "FROM Pricing";
        if (!label.equals("none")) {
            sql = sql + " WHERE label = '" + label + "'";
        } else {
            sql = sql + " where kmPrice >= " + minKmPrice + " AND kmPrice <= " + maxKmPrice +
                    " and hourlyPrice >= " + minHourlyPrice + " AND hourlyPrice <= " + maxHourlyPrice +
                    " and montlyFees >= " + minMonthlyFees + " and montlyFees <= " + maxMonthlyFees;
        }
        System.out.println(sql);
        return getCurrentSession().createQuery(sql).list();
    }


}