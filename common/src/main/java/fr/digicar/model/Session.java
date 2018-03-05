package fr.digicar.model;

import lombok.Data;

import java.util.Date;

@Data
public class Session {

    private int id;

    private Booking booking;

    private Date actualDepartureTime;

    private Date actualArrivalTime;

    private Delay delay;

}
