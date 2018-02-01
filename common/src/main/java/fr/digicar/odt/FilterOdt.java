package fr.digicar.odt;


import java.io.Serializable;

public class FilterOdt implements Serializable{
    String carBrand;
    String modelName;
    int mileageMin;
    int mileageMax;
    String typeCar;
    String transmission;
    String fuelType;

    public FilterOdt(){

    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getMileageMin() {
        return mileageMin;
    }

    public void setMileageMin(int mileageMin) {
        this.mileageMin = mileageMin;
    }

    public int getMileageMax() {
        return mileageMax;
    }

    public void setMileageMax(int mileageMax) {
        this.mileageMax = mileageMax;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    //TODO

    /**
     * Getter for parameter registrationNumber.
     * @return the registrationNumber
     */
}
