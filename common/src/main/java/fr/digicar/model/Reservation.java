package fr.digicar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_user")
    private Integer id_user;

    @Column(name = "id_car")
    private Integer id_car;

    @Column(name = "id_parking_spots")
    private Integer id_parking_spots;

    @Column(name = "start_time")
    private Timestamp start_time;

    @Column(name = "end_time")
    private Timestamp end_time;

    @Column(name = "place_back")
    private Integer place_back;

    @Column(name = "id_pricing")
    private Integer id_pricing;

}
