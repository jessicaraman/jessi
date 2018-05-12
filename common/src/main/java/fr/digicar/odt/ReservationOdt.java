package fr.digicar.odt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by barry on 10/05/2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationOdt {

    int idCar;

    String registrationNumber;

    String mark;

    String model;

    int nbDoors;

    String placeBack;

    int idPlaceBack;

    String addressParking;

    String city;

    Double price;

    int idPrice;

    String startTime;

    String endTime;

    int idParkingSpot;

    int nbSpot;
}
