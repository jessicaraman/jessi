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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setTransmission(Integer transmission) {
        this.transmission = transmission;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setDoorNumber(Integer doorNumber) {
        this.doorNumber = doorNumber;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setComfort(Integer comfort) {
        this.comfort = comfort;
    }

    public void setFuelType(Integer fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getId() {

        return id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public Integer getTransmission() {
        return transmission;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public Integer getDoorNumber() {
        return doorNumber;
    }

    public Integer getType() {
        return type;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Integer getComfort() {
        return comfort;
    }

    public Integer getFuelType() {
        return fuelType;
    }
}
