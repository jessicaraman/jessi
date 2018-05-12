package fr.digicar.backoffice.service;

import fr.digicar.dao.ReservationDAO;
import fr.digicar.model.Reservation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by barry on 12/05/2018.
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class ReservationServiceImplTest {

    @Mock
    public ReservationDAO reservationDAO;

    @InjectMocks
    private ReservationServiceImpl reservationService;


    /**
     * Unit test for getAllReservations method
     * from ReservationServiceImpl class
     */
    @Test
    public void listAllReservationsShouldReturnAllReservations() {
        //
        //GIVEN
        //
        List<Reservation> reservations = new ArrayList<>();
        reservations.add(new Reservation(1, 1, 2, 300, new Timestamp(new Date("2017-07-06 19:03:28").getTime()), new Timestamp(new Date("2017-07-06 20:03:28").getTime()), 51, 5));
        reservations.add(new Reservation(2, 10, 12, 2, new Timestamp(new Date("2017-07-06 17:03:28").getTime()), new Timestamp(new Date("2017-07-06 19:03:28").getTime()), 21, 15));
        reservations.add(new Reservation(3, 1, 23, 189, new Timestamp(new Date("2017-07-06 12:03:28").getTime()), new Timestamp(new Date("2017-07-06 17:03:28").getTime()), 33, 12));
        reservations.add(new Reservation(4, 12, 27, 253, new Timestamp(new Date("2017-07-06 08:03:28").getTime()), new Timestamp(new Date("2017-07-06 15:03:28").getTime()), 12, 17));
        reservations.add(new Reservation(5, 31, 52, 56, new Timestamp(new Date("2017-07-06 09:03:28").getTime()), new Timestamp(new Date("2017-07-06 11:03:28").getTime()), 11, 1));

        Mockito.when(reservationDAO.getAllReservations()).thenReturn(reservations);
        //
        //WHEN
        //
        List<Reservation> reservationsListTest = reservationService.getAllReservations();
        //
        //THEN
        //
        Assert.assertEquals(reservations, reservationsListTest);
    }

//    /**
//     * Unit test for getReservationById method
//     * from ReservationServiceImpl class
//     */
//    @Test
//    public void getReservationByIdShouldReturnReservation() {
//        //
//        //GIVEN
//        //
//        List<Reservation> reservations = new ArrayList<>();
//
//        Reservation reservation1 = new Reservation(3, 1, 23, 189, new Date("2017-07-06 19:03:28"), new Date("2017-07-06 20:03:28"), 33, 12);
//        Reservation reservation2 = new Reservation(4, 12, 27, 253, new Date("2017-07-06 11:03:28"), new Date("2017-07-06 15:03:28"), 12, 17);
//
//        reservations.add(new Reservation(1, 1, 2, 300, new Date("2017-07-06 08:03:28"), new Date("2017-07-06 10:03:28"), 51, 5));
//        reservations.add(new Reservation(2, 10, 12, 2, new Date("2017-07-06 09:03:28"), new Date("2017-07-06 16:03:28"), 21, 15));
//        reservations.add(reservation1);
//        reservations.add(reservation2);
//        reservations.add(new Reservation(5, 31, 52, 56, new Date("2017-07-06 12:03:28"), new Date("2017-07-06 19:03:28"), 11, 1));
//
//        Mockito.when(reservationDAO.getReservationById(3)).thenReturn(reservation1);
//        Mockito.when(reservationDAO.getReservationById(4)).thenReturn(reservation2);
//        //
//        //WHEN
//        //
//        Reservation reservationTest1 = reservationService.getReservationById(3);
//        Reservation reservationTest2 = reservationService.getReservationById(4);
//        //
//        //THEN
//        //
//        Assert.assertEquals(reservation1, reservationTest1);
//        Assert.assertEquals(reservation2, reservationTest2);
//    }
//
//    /**
//     * Unit test for getReservationByCriteria method
//     * from ReservationServiceImpl class
//     */
//    @Test
//    public void getReservationByCriteriaShouldReturnListOfReservation() {
//        //
//        //GIVEN
//        //
//        List<Reservation> reservations = new ArrayList<>();
//
//        Reservation reservation1 = new Reservation(3, 1, 23, 189, new Date("2017-07-06 19:03:28"), new Date("2017-07-06 20:03:28"), 33, 12);
//        Reservation reservation2 = new Reservation(4, 12, 27, 253, new Date("2017-07-06 11:03:28"), new Date("2017-07-06 15:03:28"), 12, 17);
//
//        reservations.add(new Reservation(1, 1, 2, 300, new Date("2017-07-06 08:03:28"), new Date("2017-07-06 10:03:28"), 51, 5));
//        reservations.add(new Reservation(2, 10, 12, 2, new Date("2017-07-06 09:03:28"), new Date("2017-07-06 16:03:28"), 21, 15));
//        reservations.add(reservation1);
//        reservations.add(reservation2);
//        reservations.add(new Reservation(5, 31, 52, 56, new Date("2017-07-06 12:03:28"), new Date("2017-07-06 19:03:28"), 11, 1));
//
//        List<Reservation> exceptedListOfReservation = Arrays.asList(reservation1);
//
//        Mockito.when(reservationDAO.getReservationByCriteria(new Date("2017-07-06 11:03:28"), new Date("2017-07-06 15:03:28"), 12)).thenReturn(exceptedListOfReservation);
//        //
//        //WHEN
//        //
//        List<Reservation> reservationListTest = reservationService.getReservationByCriteria(new Date("2017-07-06 11:03:28"), new Date("2017-07-06 15:03:28"), 12);
//        //
//        //THEN
//        //
//        Assert.assertEquals(exceptedListOfReservation, reservationListTest);
//    }


}

