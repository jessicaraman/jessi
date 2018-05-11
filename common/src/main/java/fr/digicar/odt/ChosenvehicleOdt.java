package fr.digicar.odt;

import lombok.Data;

@Data
public class ChosenvehicleOdt {

    int carId;

    int bookingId;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
