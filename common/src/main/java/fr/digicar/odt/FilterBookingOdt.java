package fr.digicar.odt;


import lombok.Data;


@Data
public class FilterBookingOdt {

    String carType;

    String startCity;

    String startTime;

    String endTime;

    String arrivedCity;

    String zipCode;

}
