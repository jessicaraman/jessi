package fr.digicar.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tarifs")
public class Tarif {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="libelle")
    private String libelle;

    @Column(name="prix_heure")
    private float prix_heure;

    @Column(name="prix_km")
    private float prix_km;

    @Column(name="frais_mensuels")
    private int frais_mensuels;

    public void setFrais_mensuels(int frais_mensuels) {
        this.frais_mensuels = frais_mensuels;
    }

    public void setPrix_km(float prix_km) {
        this.prix_km = prix_km;
    }

    public void setPrix_heure(float prix_heure) {
        this.prix_heure = prix_heure;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getPrix_km() {
        return prix_km;
    }

    public float getPrix_heure() {
        return prix_heure;
    }

    public int getFrais_mensuels() {
        return frais_mensuels;
    }

    public Integer getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
