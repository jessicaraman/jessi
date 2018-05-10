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
@Table(name = "subscription")
public class Subscription {

    @Id
    @Column(name = "id_subcription")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "id_user")
    Integer user;

    @Column(name = "id_tarif")
    Integer pricing;

    @Column(name = "start_date")
    Date startDate;

    @Column(name = "end_date")
    Date endDate;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public void setPricing(Integer pricing) {
        this.pricing = pricing;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getId() {

        return id;
    }

    public Integer getUser() {
        return user;
    }

    public Integer getPricing() {
        return pricing;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
