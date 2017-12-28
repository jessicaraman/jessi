package fr.digicar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tarif")
public class Tarif {

    @Id
    @GeneratedValue
    private Integer id;
    private String libelle;
    private float prix_heure;
    private float prix_km;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String name) {
        this.libelle = libelle;
    }

    public float getPrix_heure() {
        return prix_heure;
    }

    public float getPrix_km() {
        return prix_km;
    }

    public void setPrix_km(float prix_km) {
        this.prix_km = prix_km;
    }

    public void setPrix_heure(float prix_heure) {
        this.prix_heure = prix_heure;
    }
}
