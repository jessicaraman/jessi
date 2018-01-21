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

    /* for location: in parking or storage */
    @Column(name = "location")
    private String location;

    @Column(name = "kilometers")
    private Integer kilometers;

    @Column(name = "release_date")
    private String release_date;

    @Column(name = "comfort")
    private Integer comfort;

    @Column(name="fuel_type_id")
    private Integer fuel_type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getName_model() {
        return name_model;
    }

    public void setName_model(String name_model) {
        this.name_model = name_model;
    }

    public Integer getTransmission() {
        return transmission;
    }

    public void setTransmission(Integer transmission) {
        this.transmission = transmission;
    }

    public Integer getNb_places() {
        return nb_places;
    }

    public void setNb_places(Integer nb_places) {
        this.nb_places = nb_places;
    }

    public Integer getNb_doors() {
        return nb_doors;
    }

    public void setNb_doors(Integer nb_doors) {
        this.nb_doors = nb_doors;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Integer getComfort() {
        return comfort;
    }

    public void setComfort(Integer comfort) {
        this.comfort = comfort;
    }

    public Integer getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(Integer fuel_type) {
        this.fuel_type = fuel_type;
    }

}
