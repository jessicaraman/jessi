package fr.digicar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Entity
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
    private Integer longueur;

    @Column(name = "largeur")
    private Integer largeur;

    public ParkingSpot(int id, int nbSpot, String nbParking, boolean plug, String location, int longitude, int latitude, int longueur, int largeur) {
    }

    public Integer getLongueur() {
        return longueur;
    }

    public Integer getLargeur() {
        return largeur;
    }

    public void setLargeur(Integer largeur) {
        this.largeur = largeur;
    }

    public void setLongueur(Integer longueur) {
        this.longueur = longueur;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNbSpot() {
        return nbSpot;
    }

    public void setNbSpot(Integer nbSpot) {
        this.nbSpot = nbSpot;
    }

    public String getNbParking() {
        return nbParking;
    }

    public void setNbParking(String nbParking) {
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
