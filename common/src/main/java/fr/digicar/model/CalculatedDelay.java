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

}
