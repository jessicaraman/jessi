package fr.digicar.model;

import lombok.*;

import javax.persistence.*;
import java.lang.String;
import java.time.LocalTime;

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
    private LocalTime start_time;

    /* end of time slot */
    @Column(name="end_time")
    private LocalTime end_time;

    /* To know if this gap if is not used */
    @Column(name = "status")
    private Boolean status;


    public Availability(int id, String date, int id_occupation,
                        LocalTime start_time, LocalTime end_time, boolean status) {
        this.date = date;
        this.id_occupation = id_occupation;
        this.start_time = start_time;
        this.end_time = end_time;
        this.status = status;
    }
}
