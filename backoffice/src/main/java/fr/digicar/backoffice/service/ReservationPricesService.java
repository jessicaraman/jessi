package fr.digicar.backoffice.service;

import fr.digicar.model.ReservationPrices;

import java.util.List;

public interface ReservationPricesService {

    ReservationPrices getReservationPriceById(int id_parking_spots);

    ReservationPrices getReservationPriceByCriterias(int carType, int fuelType);

    List<ReservationPrices> getAllReservationPrices();
}
