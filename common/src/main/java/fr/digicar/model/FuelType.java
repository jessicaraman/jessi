package fr.digicar.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by barry on 15/01/2018.
 */
@Data
@Entity
<<<<<<< Updated upstream
@Table(name = "fuel_type")
=======
@Table(name = "fuelType")
>>>>>>> Stashed changes
public class FuelType {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    /* fuel type name */
    @Column(name = "name")
    private String name;
}