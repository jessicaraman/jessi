package fr.digicar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Car car;

    private Date expectedDepartureTime;

    private Date expectedArrivalTime;

}
