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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_car() {
        return id_car;
    }

    public void setId_car(Integer id_car) {
        this.id_car = id_car;
    }

    public Integer getId_parking_spots() {
        return id_parking_spots;
    }

    public void setId_parking_spots(Integer id_parking_spots) {
        this.id_parking_spots = id_parking_spots;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
}
