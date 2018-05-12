package fr.digicar.odt;

import lombok.Data;

@Data
public class DisplayUserPreferencesOdt {
    int idUser;
    String firstName;
    String lastName;
    int numberOfDiscount;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberOfDiscount() {
        return numberOfDiscount;
    }

    public void setNumberOfDiscount(int numberOfDiscount) {
        this.numberOfDiscount = numberOfDiscount;
    }

    public DisplayUserPreferencesOdt() {
    }


}
