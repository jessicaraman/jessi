package fr.digicar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car_availability")
public class CarAvailability {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "id_car")
    private Integer id_car;

    @Column(name = "id_parking_spots")
    private Integer id_parking_spots;

    @Column(name = "available")
    private String available;

}
