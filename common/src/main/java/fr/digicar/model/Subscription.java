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
@Table(name = "subscription")
public class Subscription {
    @Id
    @Column(name = "id_subcription")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id_subscription;

    @Column(name = "id_user")
    Integer id_user;

    @Column(name = "id_tarif")
    Integer id_pricing;

    @Column(name = "start_date")
    Date start_date;

    @Column(name = "end_date",nullable=true)
    Date end_date;

    public Integer getId() {
        return id_subscription;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Integer getId_pricing() {
        return id_pricing;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public void setId(Integer id) {
        this.id_subscription = id;
    }

    public void setId_pricing(Integer id_pricing) {
        this.id_pricing = id_pricing;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
        }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }
}
