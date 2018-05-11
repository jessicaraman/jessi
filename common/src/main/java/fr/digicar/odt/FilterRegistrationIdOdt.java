package fr.digicar.odt;

import lombok.Data;

@Data
public class FilterRegistrationIdOdt {
    private String registrationNumber;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}