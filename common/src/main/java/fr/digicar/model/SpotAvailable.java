package fr.digicar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "places_available")
public class SpotAvailable {

    @Id
    @Column(name = "id_parking_spots")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_parking_spots;

    @Column(name = "available")
    private String available;


}
