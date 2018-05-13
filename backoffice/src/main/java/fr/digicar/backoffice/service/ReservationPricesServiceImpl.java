package fr.digicar.backoffice.service;

import fr.digicar.dao.ReservationPricesDAO;
import fr.digicar.model.ReservationPrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservationPricesServiceImpl implements ReservationPricesService{

    @Autowired
    private ReservationPricesDAO reservationPricesDAO;


    @Override
    public ReservationPrices getReservationPriceById(int id) {
        return reservationPricesDAO.getReservationPriceById(id);
    }

    @Override
    public ReservationPrices getReservationPriceByCriterias(int carType, int fuelType){
        return reservationPricesDAO.getReservationPriceByCriterias(carType,fuelType);
    }

    @Override
    public List<ReservationPrices> getAllReservationPrices() {
        return reservationPricesDAO.getAllReservationPrices();
    }
}
