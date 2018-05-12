package fr.digicar.backoffice.service;

import fr.digicar.model.ReservationPrices;

import java.util.List;

public interface ReservationPricesService {

    ReservationPrices getReservationPriceById(int id_parking_spots);

    List<ReservationPrices> getAllReservationPrices();
}
