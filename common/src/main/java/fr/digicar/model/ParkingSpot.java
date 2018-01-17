package fr.digicar.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "parking_spots")
public class ParkingSpot {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "nb_spot")
    private String nbSpot;

    @Column(name = "nb_parking")
    private Integer nbParking;

    @Column(name = "electric_plug")
    private boolean plug;

    @Column(name = "location")
    private String location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNbSpot() {
        return nbSpot;
    }

    public void setNbSpot(String nbSpot) {
        this.nbSpot = nbSpot;
    }

    public Integer getNbParking() {
        return nbParking;
    }

    public void setNbParking(Integer nbParking) {
        this.nbParking = nbParking;
    }

    public boolean isPlug() {
        return plug;
    }

    public void setPlug(boolean plug) {
        this.plug = plug;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
