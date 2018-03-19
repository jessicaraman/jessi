package fr.digicar.model;

import lombok.*;

import javax.persistence.*;
import java.lang.String;

/*
 * Created by barry on 31/12/2017.
 */

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "availability")
public class Availability {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "date")
    private String date;

    @Column(name = "id_occupation")
    private Integer id_occupation;

    /* start of time slot */
    @Column(name = "start_time")
    private String start_time;

    /* end of time slot */
    @Column(name="end_time")
    private String end_time;

    /* To know if this gap is not used */
    @Column(name = "status")
    private Boolean status;


    public Availability(int id, String date, int id_occupation,
                        String start_time, String end_time, boolean status) {
        this.date = date;
        this.id_occupation = id_occupation;
        this.start_time = start_time;
        this.end_time = end_time;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getId_occupation() {
        return id_occupation;
    }

    public void setId_occupation(Integer id_occupation) {
        this.id_occupation = id_occupation;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
