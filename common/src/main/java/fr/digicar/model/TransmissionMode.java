package fr.digicar.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by barry on 15/01/2018.
 */
@Data
@Entity
@Table(name = "transmission_mode")
public class TransmissionMode {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    /**
     * Tramsmission mode name
     */
    @Column(name = "name")
    private String name;

}