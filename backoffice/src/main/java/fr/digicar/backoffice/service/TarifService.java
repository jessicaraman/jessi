package fr.digicar.backoffice.service;

import fr.digicar.model.Pricing;

import java.util.List;

public interface TarifService {

    void addTarif(Pricing pricing);

    void updateTarif(Pricing pricing);

    Pricing getTarif(int id);

    void deleteTarif(int id);

    List<Pricing> getTarifs();

    List<Pricing> searchTarifs(String label, float minKmPrice, float maxKmPrice, float minHourlyPrice, float maxHoulyPrice, int minMonthlyFees, int maxMonthlyFees);

}
