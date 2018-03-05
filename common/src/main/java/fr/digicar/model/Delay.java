package fr.digicar.model;

import lombok.Data;

@Data
public class Delay {

    private int id;

    private Session session;

    private long duration;

}
