package fr.digicar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invoice")
public class Invoice {

    @Id
    @Column(name = "id_invoice")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "id_user")
    private Integer user;

    @Column(name = "date")
    private Date date;

    @Column(name = "amount")
    private double amount;

    @Column(name = "url")
    private String url;

    public Invoice(Integer idUser, Date date, double amount, String url) {
        this.user = idUser;
        this.date = date;
        this.amount = amount;
        this.url = url;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {

        return id;
    }

    public Integer getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getUrl() {
        return url;
    }
}
