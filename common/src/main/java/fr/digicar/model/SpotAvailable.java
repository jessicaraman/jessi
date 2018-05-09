package fr.digicar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "places_available")
public class SpotAvailable {

    @Column(name = "id_parking_spots")
    private Integer id_parking_spots;

    @Column(name = "available")
    private String available;


}
