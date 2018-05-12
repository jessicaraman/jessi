package fr.digicar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

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

    public void setId(int id) {
        this.id = id;
    }

    public void setBooking(int booking) {
        this.booking = booking;
    }

    public void setCar(int car) {
        this.car = car;
    }

    public void setDepartureParkingSpot(int departureParkingSpot) {
        this.departureParkingSpot = departureParkingSpot;
    }

    public void setArrivalParkingSpot(int arrivalParkingSpot) {
        this.arrivalParkingSpot = arrivalParkingSpot;
    }

    public void setActualDepartureTime(Timestamp actualDepartureTime) {
        this.actualDepartureTime = actualDepartureTime;
    }

    public void setExpectedArrivalTime(Timestamp expectedArrivalTime) {
        this.expectedArrivalTime = expectedArrivalTime;
    }

    public void setActualArrivalTime(Timestamp actualArrivalTime) {
        this.actualArrivalTime = actualArrivalTime;
    }

    public void setPricing(double pricing) {
        this.pricing = pricing;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void setTag(boolean tag) {
        this.tag = tag;
    }

    public void setPenality(float penality) {
        this.penality = penality;
    }

    public void setLatitudeCurrent(float latitudeCurrent) {
        this.latitudeCurrent = latitudeCurrent;
    }

    public void setLongitudeCurrent(float longitudeCurrent) {
        this.longitudeCurrent = longitudeCurrent;
    }

    public int getId() {

        return id;
    }

    public int getBooking() {
        return booking;
    }

    public int getCar() {
        return car;
    }

    public int getDepartureParkingSpot() {
        return departureParkingSpot;
    }

    public int getArrivalParkingSpot() {
        return arrivalParkingSpot;
    }

    public Timestamp getActualDepartureTime() {
        return actualDepartureTime;
    }

    public Timestamp getExpectedArrivalTime() {
        return expectedArrivalTime;
    }

    public Timestamp getActualArrivalTime() {
        return actualArrivalTime;
    }

    public double getPricing() {
        return pricing;
    }

    public int getUser() {
        return user;
    }

    public boolean isTag() {
        return tag;
    }

    public float getPenality() {
        return penality;
    }

    public float getLatitudeCurrent() {
        return latitudeCurrent;
    }

    public float getLongitudeCurrent() {
        return longitudeCurrent;
    }
}

