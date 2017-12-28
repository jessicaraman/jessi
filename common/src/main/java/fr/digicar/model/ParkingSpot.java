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

    @Column(name = "status")
    private String status;

    @Column(name = "location")
    private String location;

}
