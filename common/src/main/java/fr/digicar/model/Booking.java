package fr.digicar.model;

import lombok.Data;

import java.util.Date;

@Data
public class Booking {

    private int id;

    private User user;

    private Car car;

    private Date expectedDepartureTime;

    private Date expectedArrivalTime;

}
