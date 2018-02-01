package fr.digicar.odt;

import java.io.Serializable;

public class FilterRegistrationIdOdt implements Serializable {
    private String registrationNumber;
    /**
     * Getter for parameter registrationNumber.
     * @return the registrationNumber
     */
    public String getregistrationNumber() {
        return registrationNumber;
    }
    /**
     * Setter for parameter registrationNumber.
     * @param registrationNumber the registrationNumber to set
     */
    public void setregistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}