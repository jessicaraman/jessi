package fr.digicar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car_availability")
public class CarAvailability {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_car")
    private Integer id_car;

    @Column(name = "id_parking_spots")
    private Integer id_parking_spots;

    @Column(name = "available")
    private String available;

    public CarAvailability(Integer id_car, Integer id_parking_spots, String available) {
        this.id_car = id_car;
        this.id_parking_spots = id_parking_spots;
        this.available = available;

    }
}
