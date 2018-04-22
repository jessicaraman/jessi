package fr.digicar.dao;

import fr.digicar.model.Pricing;

import java.util.List;

public interface PricingDAO {

    void addTarif(Pricing pricing);

    void updateTarif(Pricing pricing);

    Pricing getTarif(int id);

    void deleteTarif(int id);

    List<Pricing> getTarifs();

    List<Pricing> getTarifsByLibelle(String label);

    List<Pricing> searchTarifs(String label, float minKmPrice, float maxKmPrice, float minHourlyPrice, float maxHourlyPrice, int minMonthlyFees, int maxMonthlyFees);

}
