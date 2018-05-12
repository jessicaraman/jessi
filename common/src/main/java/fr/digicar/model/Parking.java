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
@Table(name = "parking")
public class Parking {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_nb_parking")
    private String id_nb_parking;

    @Column(name = "road_name")
    private String road_name;

}
