package fr.digicar.dao;

import fr.digicar.model.Pricing;

import java.util.List;

public interface PricingDAO {

    void addPricing(Pricing pricing);

    void updatePricing(Pricing pricing);

    Pricing getPricing(int id);

    void deletePricing(int id);

    List<Pricing> getPricings();

    List<Pricing> getPricingsByLabel(String label);

    List<Pricing> searchPricings(String label, float minKmPrice, float maxKmPrice, float minHourlyPrice, float maxHourlyPrice, int minMonthlyFees, int maxMonthlyFees);

}
