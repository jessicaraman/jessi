package fr.digicar.backoffice.service;

import fr.digicar.dao.ReservationPricesDAO;
import fr.digicar.model.Car;
import fr.digicar.model.Parking;
import fr.digicar.model.ReservationPrices;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by barry on 12/05/2018.
 */


@RunWith(MockitoJUnitRunner.Silent.class)
public class ReservationPricesServiceImplTest {

    @Mock
    private ReservationPricesDAO reservationPricesDAO;

    @InjectMocks
    private ReservationPricesServiceImpl reservationPricesService;


    /**
     * Unit test for getAllReservationPrices method
     * from ReservationPricesServiceImpl class
     */
    @Test
    public void listAllReservationPricesShouldReturnAllReservationPrices() {
        //
        //GIVEN
        //
        List<ReservationPrices> reservationPrices = new ArrayList<>();
        reservationPrices.add(new ReservationPrices(1, 3, 1, 0.15, 0.10, 0.05));
        reservationPrices.add(new ReservationPrices(2, 1, 3, 0.12, 0.7, 0.04));
        reservationPrices.add(new ReservationPrices(3, 4, 1, 0.25, 0.20, 0.25));
        reservationPrices.add(new ReservationPrices(4, 1, 2, 0.14, 0.09, 0.04));

        Mockito.when(reservationPricesDAO.getAllReservationPrices()).thenReturn(reservationPrices);
        //
        //WHEN
        //
        List<ReservationPrices> reservationPricesTest = reservationPricesService.getAllReservationPrices();
        //
        //THEN
        //
        Assert.assertEquals(reservationPrices, reservationPricesTest);
    }

    /**
     * Unit test for getReservationPriceById method
     * from ReservationPricesServiceImpl class
     */
    @Test
    public void getReservationPriceByIdShouldReturnReservationPrice() {
        //
        //GIVEN
        //
        List<ReservationPrices> reservationPrices = new ArrayList<>();
        ReservationPrices reservationPrices1 = new ReservationPrices(1, 3, 1, 0.15, 0.10, 0.05);
        ReservationPrices exceptedReservationPrices = new ReservationPrices(2, 1, 3, 0.12, 0.7, 0.04);
        ReservationPrices reservationPrices3 = new ReservationPrices(3, 4, 1, 0.25, 0.20, 0.25);
        ReservationPrices reservationPrices4 = new ReservationPrices(4, 1, 2, 0.14, 0.09, 0.04);

        reservationPrices.add(reservationPrices1);
        reservationPrices.add(exceptedReservationPrices);
        reservationPrices.add(reservationPrices3);
        reservationPrices.add(reservationPrices4);

        when(reservationPricesDAO.getReservationPriceById(exceptedReservationPrices.getId())).thenReturn(exceptedReservationPrices);

        //
        //WHEN
        //
        ReservationPrices reservationPricesTest = reservationPricesService.getReservationPriceById(2);

        //
        //THEN
        //
        Assert.assertEquals(exceptedReservationPrices, reservationPricesTest);
    }
}

