package fr.digicar.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "session")
public class Session {
public Session(){}
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "car_registration_id")
    String car_registration_id;

    @Column(name = "departure_date")
    Timestamp departure_date;

    @Column(name = "arrival_date")
    Timestamp arrival_date;

    @Column(name = "id_car")
    Integer id_car;

    @Column(name = "id_user")
    Integer id_user;

    @Column(name = "id_delay")
    Integer id_delay;
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
        return departure_date;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public Integer getId_car() {
        return id_car;
    }

    public Integer getId_user() {
        return id_user;
    }

    public Integer getId_delay() {
        return id_delay;
    }

    public Session(Date departure_date, Date arrival_date, Integer id_car, Integer id_user, Integer id_delay) {

        this.departure_date = (Timestamp) departure_date;
        this.arrival_date = (Timestamp) arrival_date;
        this.id_car = id_car;
        this.id_user = id_user;
        this.id_delay = id_delay;
    }
}
