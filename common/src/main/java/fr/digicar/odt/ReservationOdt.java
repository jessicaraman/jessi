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

    String mark;

    String model;

    int nbDoors;

    String addressParking;

}
