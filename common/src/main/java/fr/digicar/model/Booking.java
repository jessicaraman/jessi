package fr.digicar.model;


import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "car_registration_id")
    private String car_registration_id;
    @Column(name = "departure_date")
    private Timestamp departure_date;
    @Column(name = "arrival_date")
    private Timestamp arrival_date;
    @Column(name = "id_car")
    private Integer id_car;
    @Column(name = "id_user")
    private Integer id_user;
    @Column(name = "id_place_depart")
    private int idPlaceDepart;
    @Column(name = "id_place_arrivee")
    private int idPlaceArrivee;

    public Booking(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCar_registration_id() {
        return car_registration_id;
    }

    public void setCar_registration_id(String car_registration_id) {
        this.car_registration_id = car_registration_id;
    }

    public Timestamp getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Timestamp departure_date) {
        this.departure_date = departure_date;
    }

    public Timestamp getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Timestamp arrival_date) {
        this.arrival_date = arrival_date;
    }

    public Integer getId_car() {
        return id_car;
    }

    public void setId_car(Integer id_car) {
        this.id_car = id_car;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public int getIdPlaceDepart() {
        return idPlaceDepart;
    }

    public void setIdPlaceDepart(int idPlaceDepart) {
        this.idPlaceDepart = idPlaceDepart;
    }

    public int getIdPlaceArrivee() {
        return idPlaceArrivee;
    }

    public void setIdPlaceArrivee(int idPlaceArrivee) {
        this.idPlaceArrivee = idPlaceArrivee;
    }

}
