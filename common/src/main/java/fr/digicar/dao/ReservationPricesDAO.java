package fr.digicar.dao;

import fr.digicar.model.ReservationPrices;

import java.util.List;

public interface ReservationPricesDAO {

    ReservationPrices getReservationPriceById(int id);

    ReservationPrices getReservationPriceByCriterias(int carType, int fuelType);

    List<ReservationPrices> getAllReservationPrices();

}
