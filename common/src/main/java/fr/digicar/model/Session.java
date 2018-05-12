package fr.digicar.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "session")
public class Session {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "car_registration_id")
    String car_registration_id;

    @Column(name = "departure_date")
    Timestamp departureDate;

    @Column(name = "arrival_date")
    Timestamp arrivalDate;

    @Column(name = "id_car")
    Integer car;

    @Column(name = "id_user")
    Integer user;

    @Column(name = "id_delay")
    Integer delay;

    @Column(name = "kms")
    Integer kms;

    public String getCar_registration_id() {
        return car_registration_id;
    }

    public void setCar_registration_id(String car_registration_id) {
        this.car_registration_id = car_registration_id;
    }
    public Integer getKms() {
        return kms;
    }

    public int getId() {
        return id;
    }

    public Date getDeparture_date() {
        return departureDate;
    }

    public Date getArrival_date() {
        return arrivalDate;
    }

    public Session(Date departureDate, Date arrivalDate, Integer car, Integer user, Integer delay) {
        this.departureDate = (Timestamp) departureDate;
        this.arrivalDate = (Timestamp) arrivalDate;
        this.car = car;
        this.user = user;
        this.delay = delay;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartureDate(Timestamp departureDate) {
        this.departureDate = departureDate;
    }

    public void setArrivalDate(Timestamp arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setCar(Integer car) {
        this.car = car;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public void setKms(Integer kms) {
        this.kms = kms;
    }

    public Timestamp getDepartureDate() {

        return departureDate;
    }

    public Timestamp getArrivalDate() {
        return arrivalDate;
    }

    public Integer getCar() {
        return car;
    }

    public Integer getUser() {
        return user;
    }

    public Integer getDelay() {
        return delay;
    }
}
