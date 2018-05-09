package fr.digicar.backoffice.service;

import fr.digicar.dao.ReservationPricesDAO;
import fr.digicar.model.ReservationPrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationPricesServiceImpl implements ReservationPricesService{

    @Autowired
    private ReservationPricesDAO reservationPricesDAO;


    @Override
    public ReservationPrices getReservationPriceById(int id) {
        return reservationPricesDAO.getReservationPriceById(id);
    }

    @Override
    public List<ReservationPrices> getAllReservationPrices() {
        return reservationPricesDAO.getAllReservationPrices();
    }
}
