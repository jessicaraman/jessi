package fr.digicar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parkingSpot")
public class ParkingSpot {

    @Id
    @GeneratedValue
    private Integer id;
    private String nbSpot;
    private Integer nbParking;
    private String status;
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

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
