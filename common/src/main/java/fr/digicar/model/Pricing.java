package fr.digicar.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tarifs")
public class Pricing {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "libelle")
    private String label;

    @Column(name = "prix_heure")
    private float hourlyPrice;

    @Column(name = "prix_km")
    private float kmPrice;

    @Column(name = "frais_mensuels")
    private int monthlyFees;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setHourlyPrice(float hourlyPrice) {
        this.hourlyPrice = hourlyPrice;
    }

    public void setKmPrice(float kmPrice) {
        this.kmPrice = kmPrice;
    }

    public void setMonthlyFees(int monthlyFees) {
        this.monthlyFees = monthlyFees;
    }

    public Integer getId() {

        return id;
    }

    public String getLabel() {
        return label;
    }

    public float getHourlyPrice() {
        return hourlyPrice;
    }

    public float getKmPrice() {
        return kmPrice;
    }

    public int getMonthlyFees() {
        return monthlyFees;
    }
}
