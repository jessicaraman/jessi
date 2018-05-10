package fr.digicar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "parking_spots")
public class ParkingSpot {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "nb_spot")
    private Integer nbSpot;

    @Column(name = "nb_parking")
    private String nbParking;

    @Column(name = "electric_plug")
    private boolean plug;

    @Column(name = "location")
    private String location;

    @Column(name = "longitude")
    private float longitude;

    @Column(name = "latitude")
    private float latitude;

    @Column(name = "longueur")
    private Integer length;

    @Column(name = "largeur")
    private Integer width;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNbSpot(Integer nbSpot) {
        this.nbSpot = nbSpot;
    }

    public void setNbParking(String nbParking) {
        this.nbParking = nbParking;
    }

    public void setPlug(boolean plug) {
        this.plug = plug;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getId() {

        return id;
    }

    public Integer getNbSpot() {
        return nbSpot;
    }

    public String getNbParking() {
        return nbParking;
    }

    public boolean isPlug() {
        return plug;
    }

    public String getLocation() {
        return location;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getWidth() {
        return width;
    }
}
