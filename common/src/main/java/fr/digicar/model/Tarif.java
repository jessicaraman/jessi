package fr.digicar.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tarifs")
public class Tarif {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "prix_heure")
    private float prix_heure;

    @Column(name = "prix_km")
    private float prix_km;

}
