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
@Table(name = "pricing")
public class ReservationPrices {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_car_type")
    private Integer id_car_type;

    @Column(name = "id_fuel_type")
    private Integer id_fuel_type;

    @Column(name = "pricing_minute_standard")
    private Double pricing_minute_standard;

    @Column(name = "pricing_minute_premium")
    private Double pricing_minute_premium;

    @Column(name = "pricing_minute_pro")
    private Double pricing_minute_pro;

}
