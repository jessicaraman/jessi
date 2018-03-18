package fr.digicar.model;

import lombok.Data;

import javax.persistence.*;
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


    @Column(name = "departure_date")
    String departure_date;

    @Column(name = "arrival_date")
    String arrival_date;

    @Column(name = "id_car")
    Integer id_car;

    @Column(name = "id_user")
    Integer id_user;

    @Column(name = "id_delay")
    Integer id_delay;
    @Column(name = "kms")
    Integer kms;

    public Integer getKms() {
        return kms;
    }

    public int getId() {
        return id;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public String getArrival_date() {
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

    public Session(String departure_date, String arrival_date, Integer id_car, Integer id_user, Integer id_delay) {

        this.departure_date = departure_date;
        this.arrival_date = arrival_date;
        this.id_car = id_car;
        this.id_user = id_user;
        this.id_delay = id_delay;
    }
}
