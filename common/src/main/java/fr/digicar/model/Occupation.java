package fr.digicar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by barry on 31/12/2017.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "occupation")
public class Occupation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "car_id")
    private Integer car;

    @Column(name = "parking_spots_id")
    private Integer parkingSpot;

    public Occupation(int car, int parkingSpot) {
        this.car = car;
        this.parkingSpot = parkingSpot;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCar(Integer car) {
        this.car = car;
    }

    public void setParkingSpot(Integer parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Integer getId() {

        return id;
    }

    public Integer getCar() {
        return car;
    }

    public Integer getParkingSpot() {
        return parkingSpot;
    }
}
