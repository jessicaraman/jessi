package fr.digicar.odt;

import lombok.Data;

@Data
public class FilterOdt {
    String carBrand;
    String modelName;
    String mileageMin;
    String mileageMax;
    String typeCar;
    String transmission;
    String fuelType;

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

    public String getMileageMin() {
        return mileageMin;
    }

    public void setMileageMin(String mileageMin) {
        this.mileageMin = mileageMin;
    }

    public String getMileageMax() {
        return mileageMax;
    }

    public void setMileageMax(String mileageMax) {
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
}
