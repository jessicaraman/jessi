package fr.digicar.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tarifs")
public class Tarif {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String libelle;
    private float prix_heure;
    private float prix_km;
    private int frais_mensuels;
public Integer getId(){return this.id;};

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle(){return this.libelle;}

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getPrix_heure(){return this.prix_heure;}

    public void setPrix_heure(float prix_heure) {
        this.prix_heure = prix_heure;
    }

    public float getPrix_km(){return this.prix_km;}

    public void setPrix_km(float prix_km) {
        this.prix_km = prix_km;
    }

    public void setFrais_mensuels(int frais_mensuels) {
        this.frais_mensuels = frais_mensuels;
    }
    public int getFrais_mensuels(){
        return this.frais_mensuels;
    }
}
