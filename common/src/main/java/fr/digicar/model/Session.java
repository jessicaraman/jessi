package fr.digicar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Session {

    @Id
    private int id;

    @OneToOne
    private Booking booking;

    private Date actualDepartureTime;

    private Date actualArrivalTime;

    @OneToOne
    private Delay delay;

}
