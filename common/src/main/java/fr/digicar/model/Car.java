package fr.digicar.model;

import lombok.Data;

import javax.persistence.*;

/**
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

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "nb_places")
    private Integer nb_places;

    @Column(name = "nb_doors")
    private Integer nb_doors;

    @Column(name = "category")
    private String category;

