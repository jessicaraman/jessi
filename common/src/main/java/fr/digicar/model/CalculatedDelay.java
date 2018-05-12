package fr.digicar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "retard_calcule")
public class CalculatedDelay {

    @Id
    @GeneratedValue
    @Column(name = "id_retard")
    private int id;

    @Column(name = "immatriculation")
    private String registrationNumber;

    @Column(name = "mark")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "heure_retour_prevu")
    private Time expectedReturnTime;

    @Column(name = "heure_retour_calcule")
    private Time calculatedReturnTime;

    @Column(name = "date_retour_calcule")
    Timestamp calculatedReturnDateTime;

    @Column(name = "penality")
    private float penality;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "tag_appel")
    private boolean tagAppel;

    @Column(name = "id_session")
    private int idSession;

    public void setId(int id) {
        this.id = id;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setExpectedReturnTime(Time expectedReturnTime) {
        this.expectedReturnTime = expectedReturnTime;
    }

    public void setCalculatedReturnTime(Time calculatedReturnTime) {
        this.calculatedReturnTime = calculatedReturnTime;
    }

    public void setCalculatedReturnDateTime(Timestamp calculatedReturnDateTime) {
        this.calculatedReturnDateTime = calculatedReturnDateTime;
    }

    public void setPenality(float penality) {
        this.penality = penality;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setTagAppel(boolean tagAppel) {
        this.tagAppel = tagAppel;
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }

    public int getId() {

        return id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Time getExpectedReturnTime() {
        return expectedReturnTime;
    }

    public Time getCalculatedReturnTime() {
        return calculatedReturnTime;
    }

    public Timestamp getCalculatedReturnDateTime() {
        return calculatedReturnDateTime;
    }

    public float getPenality() {
        return penality;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isTagAppel() {
        return tagAppel;
    }

    public int getIdSession() {
        return idSession;
    }
}
