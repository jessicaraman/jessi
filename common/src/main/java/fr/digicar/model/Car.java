package fr.digicar.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/*
 * Created by barry on 31/12/2017.
 */
@Data
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "registration_number")
    private String registration_number;

    @Column(name = "mark")
    private String mark;

    @Column(name = "name_model")
    private String name_model;

    @OneToOne(targetEntity = TransmissionMode.class)
    @JoinColumn(name="id")
//    @JoinTable(name="transmission_mode",
//              joinColumns = @JoinColumn(name="transmission_id"),
//              inverseJoinColumns = @JoinColumn(name="id"))
    private TransmissionMode transmission;

    @Column(name = "nb_places")
    private Integer nb_places;

    @Column(name = "nb_doors")
    private Integer nb_doors;

    @OneToOne(targetEntity = CarType.class)
    @JoinColumn(name="id")
//    @JoinTable(name="car_type",
//            joinColumns = @JoinColumn(name="type_id"),
//            inverseJoinColumns = @JoinColumn(name="id"))
    private CarType type;

    /* for location: in parking or storage */
    @Column(name = "location")
    private String location;

    @Column(name = "kilometers")
    private Integer kilometers;

    @Column(name = "release_date")
    private String release_date;

    @Column(name = "comfort")
    private Integer comfort;

//    @JoinTable(name="fuel_type",
//            joinColumns = @JoinColumn(name="fuel_type_id"),
//            inverseJoinColumns = @JoinColumn(name="id"))
    @OneToOne(targetEntity=FuelType.class) // le ManyToOne fait toujours reference à l'entité
    @JoinColumn(name="id")
    private FuelType fuel_type;

}
