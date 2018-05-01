package fr.digicar.model;


import lombok.Data;
import javax.persistence.*;

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
    private Integer date_fin_validite;
}
