package fr.digicar.odt;


import lombok.Data;

@Data
public class FilterBookingOdt {

    String wishedDate;

    String startTime;

    String endTime;

    String zipCode;

    public String getWishedDate() {
        return wishedDate;
    }

    public void setWishedDate(String wishedDate) {
        this.wishedDate = wishedDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
