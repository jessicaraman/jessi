package fr.digicar.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "token")
public class Token {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "id_user")
    private int userId;

    @Column(name = "solde")
    private int solde;

    @Column(name = "gold")
    private boolean gold;

    @Column(name = "tillNext")
    private int tillNext;
}
