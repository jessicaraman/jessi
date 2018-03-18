package fr.digicar.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @Column(name = "id_invoice")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    public Invoice(Integer id_user, Date date, double amount, String url) {
        this.id_user = id_user;
        this.date = date;
        this.amount = amount;
        this.url = url;
    }

    @Column(name = "id_user")
    Integer id_user;

    @Column(name = "date")
    Date date;

    @Column(name = "amount")
    double amount;
    @Column(name = "url")
    String url;

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public Integer getId() {
        return id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
