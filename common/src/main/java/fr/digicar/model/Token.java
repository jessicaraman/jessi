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
    private int gold;

    @Column(name = "tillNext")
    private float tillNext;
    @Column(name = "totalEarned")
    private int totalEarned;

    public void increment(int amount){
        setSolde(solde+amount);
        setTotalEarned(totalEarned+amount);
    }
    public void decrecrement(int amount){
        setSolde(solde-amount);
    }
    public void resteToken (float amount){
        setTillNext(tillNext+amount);
    }
}
