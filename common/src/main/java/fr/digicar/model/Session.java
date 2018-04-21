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

    public Session(Date departureDate, Date arrivalDate, Integer car, Integer user, Integer delay) {
        this.departureDate = (Timestamp) departureDate;
        this.arrivalDate = (Timestamp) arrivalDate;
        this.car = car;
        this.user = user;
        this.delay = delay;
    }

}
