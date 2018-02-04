package fr.digicar.model;

import lombok.*;

import javax.persistence.*;

/*
 * Created by barry on 31/12/2017.
 */

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "registration_number")
    private String registration_number;

    @Column(name = "mark")
    private String mark;

    @Column(name = "name_model")
    private String name_model;

    @Column(name="transmission_id")
    private Integer transmission;

    @Column(name = "nb_places")
    private Integer nb_places;

    @Column(name = "nb_doors")
    private Integer nb_doors;

    @Column(name="type_id")
    private Integer type;

    @Column(name = "kilometers")
    private Integer kilometers;

    @Column(name = "release_date")
    private String release_date;

    @Column(name = "comfort")
    private Integer comfort;

    @Column(name="fuel_type_id")
    private Integer fuel_type;

    public Car(int id, String registration_number, String mark, String name_model, int transmission, int nb_places, int nb_doors, int type, int kilometers, String release_date, int comfort, int fuel_type) {
        this.registration_number = registration_number;
        this.mark = mark;
        this.name_model = name_model;
        this.transmission = transmission;
        this.nb_places = nb_places;
        this.nb_doors = nb_doors;
        this.type = type;
        this.kilometers = kilometers;
        this.release_date = release_date;
        this.comfort = comfort;
        this.fuel_type = fuel_type;
    }
}
