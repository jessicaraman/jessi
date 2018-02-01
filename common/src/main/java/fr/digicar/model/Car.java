package fr.digicar.model;

import lombok.*;

import javax.persistence.*;

/*
 * Created by barry on 31/12/2017.
 */
@ToString
@EqualsAndHashCode
@Data
@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "registration_number")
    private String registration_number;

    @Column(name = "mark")
    private String mark;

    @Column(name = "name_model")
    private String name_model;

    @Column(name="transmission_id")
    private Integer transmission;

    @Column(name = "nb_places")
    private Integer nb_places;

    @Column(name = "nb_doors")
    private Integer nb_doors;

    @Column(name="type_id")
    private Integer type;

    @Column(name = "kilometers")
    private Integer kilometers;

    @Column(name = "release_date")
    private String release_date;

    @Column(name = "comfort")
    private Integer comfort;

    @Column(name="fuel_type_id")
    private Integer fuel_type;
}
