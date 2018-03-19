package fr.digicar.model;

import lombok.*;

import javax.persistence.*;

/*
 * Created by barry on 31/12/2017.
 */

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "occupation")
public class Occupation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "car_id")
    private Integer car_id;

    @Column(name = "parking_spots_id")
    private Integer parking_spots_id;


    public Occupation(int id, int car_id, int parking_spots_id) {
        this.car_id = car_id;
        this.parking_spots_id = parking_spots_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    public Integer getParking_spots_id() {
        return parking_spots_id;
    }

    public void setParking_spots_id(Integer parking_spots_id) {
        this.parking_spots_id = parking_spots_id;
    }
}
