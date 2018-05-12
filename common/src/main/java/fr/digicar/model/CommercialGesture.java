package fr.digicar.model;


import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "commercial_gesture")
public class CommercialGesture {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "id_user")
    private int id_user;
    @Column(name = "code")
    private String code;
    @Column(name = "valeur")
    private Float valeur;
    @Column(name = "date_fin_validite")
    private Timestamp date_fin_validite;

    public CommercialGesture() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setValeur(Float valeur) {
        this.valeur = valeur;
    }

    public void setDate_fin_validite(Timestamp date_fin_validite) {
        this.date_fin_validite = date_fin_validite;
    }

    public int getId() {

        return id;
    }

    public int getId_user() {
        return id_user;
    }

    public String getCode() {
        return code;
    }

    public Float getValeur() {
        return valeur;
    }

    public Timestamp getDate_fin_validite() {
        return date_fin_validite;
    }
}
