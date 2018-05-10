package fr.digicar.odt;


import lombok.Data;

@Data
public class FilterBookingOdt {

    String carType;

    String wishedDate;

    String startTime;

    String endTime;

    String city;

}
