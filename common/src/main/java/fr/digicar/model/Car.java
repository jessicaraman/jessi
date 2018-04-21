package fr.digicar.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by barry on 31/12/2017.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "mark")
    private String brandName;

    @Column(name = "name_model")
    private String modelName;

    @Column(name = "transmission_id")
    private Integer transmission;

    @Column(name = "nb_places")
    private Integer seatNumber;

    @Column(name = "nb_doors")
    private Integer doorNumber;

    @Column(name = "type_id")
    private Integer type;

    @Column(name = "kilometers")
    private Integer kilometers;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "comfort")
    private Integer comfort;

    @Column(name = "fuel_type_id")
    private Integer fuelType;

    public Car(String registrationNumber, String brandName, String modelName, int transmission, int seatNumber, int doorNumber, int type, int kilometers, String releaseDate, int comfort, int fuelType) {
        this.registrationNumber = registrationNumber;
        this.brandName = brandName;
        this.modelName = modelName;
        this.transmission = transmission;
        this.seatNumber = seatNumber;
        this.doorNumber = doorNumber;
        this.type = type;
        this.kilometers = kilometers;
        this.releaseDate = releaseDate;
        this.comfort = comfort;
        this.fuelType = fuelType;
    }

}
