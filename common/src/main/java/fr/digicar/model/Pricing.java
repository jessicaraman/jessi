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

}
