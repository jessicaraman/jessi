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
}
