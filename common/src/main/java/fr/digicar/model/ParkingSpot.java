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

}
