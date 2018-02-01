package fr.digicar.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by barry on 15/01/2018.
 */

@Data
@Entity
@Table(name = "car_type")
public class CarType {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    /* car type name */
    @Column(name = "name")
    private String name;
}
