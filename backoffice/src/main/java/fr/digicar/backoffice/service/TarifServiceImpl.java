package fr.digicar.backoffice.service;

import fr.digicar.dao.PricingDAO;
import fr.digicar.model.Pricing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TarifServiceImpl implements TarifService {

    @Autowired
    private PricingDAO pricingDAO;

    @Override
    public void addTarif(Pricing pricing) {
        pricingDAO.addTarif(pricing);
    }

    @Override
    public void updateTarif(Pricing pricing) {
        pricingDAO.updateTarif(pricing);
    }

    @Override
    public Pricing getTarif(int id) {
        return pricingDAO.getTarif(id);
    }

    @Override
    public void deleteTarif(int id) {
        pricingDAO.deleteTarif(id);
    }

    @Override
    public List<Pricing> getTarifs() {
        return pricingDAO.getTarifs();
    }

    @Override
    public List<Pricing> searchTarifs(String label, float minKmPrice, float maxKmPrice, float minHourlyPrice, float maxHoulyPrice, int minMonthlyFees, int maxMonthlyFees) {
        return pricingDAO.searchTarifs(label, minKmPrice, maxKmPrice, minHourlyPrice, maxHoulyPrice, minMonthlyFees, maxMonthlyFees);
    }

}
