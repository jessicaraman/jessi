package fr.digicar.odt;

import lombok.Data;

@Data
public class DisplayUserPreferencesOdt {
    int idUser;
    int numberOfDiscount;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
