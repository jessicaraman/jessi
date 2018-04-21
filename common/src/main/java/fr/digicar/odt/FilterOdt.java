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
}
