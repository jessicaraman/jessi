package fr.digicar.dao;

import fr.digicar.model.ReservationPrices;

import java.util.List;

public interface ReservationPricesDAO {

    ReservationPrices getReservationPriceById(int id);

    List<ReservationPrices> getAllReservationPrices();

}
