package fr.digicar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "history_delays")
public class Delay {

    @Id
    @Column(name = "delay_id")
    private int id;

    @Column(name = "duration")
    private int duration;

    @Column(name = "session_end_date")
    private Date date;

    public void setId(int id) {
        this.id = id;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {

        return id;
    }

    public int getDuration() {
        return duration;
    }

    public Date getDate() {
        return date;
    }
}
