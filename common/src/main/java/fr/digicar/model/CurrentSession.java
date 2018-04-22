package fr.digicar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "session_en_cours")
public class CurrentSession {

    @Id
    @GeneratedValue
    @Column(name = "id_session")
    private int id;

    @Column(name = "id_reservation")
    private int booking;

    @Column(name = "id_car")
    private int car;

    @Column(name = "id_place_depart")
    private int departureParkingSpot;

    @Column(name = "id_place_arrivee")
    private int arrivalParkingSpot;

    @Column(name = "heure_depart_reel")
    private java.sql.Timestamp actualDepartureTime;

    @Column(name = "heure_arrivee_prevu")
    private java.sql.Timestamp expectedArrivalTime;

    @Column(name = "heure_arrivee_reel")
    private java.sql.Timestamp actualArrivalTime;

    @Column(name = "tarif")
    private double pricing;

    @Column(name = "id_user")
    private int user;

    @Column(name = "tag")
    private boolean tag;

    @Column(name = "penality")
    private float penality;

    @Column(name = "latitude_current")
    private float latitudeCurrent;

    @Column(name = "longitude_current")
    private float longitudeCurrent;

}

