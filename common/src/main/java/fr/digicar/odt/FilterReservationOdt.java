package fr.digicar.odt;


import java.io.Serializable;

public class FilterReservationOdt implements Serializable{
    String wishedDate;
    String start_time;
    String end_time;
    String postal_code;

    public FilterReservationOdt(){

    }

    public String getWishedDate() {
        return wishedDate;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setWishedDate(String date) {
        this.wishedDate = wishedDate;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }
}
