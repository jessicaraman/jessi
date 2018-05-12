package fr.digicar.odt;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class CommercialGestureOdt {
        private String bonCode;

        private int bookingIdForCommercialFGesture;

        public String getBonCode() {
                return bonCode;
        }

        public void setBonCode(String bonCode) {
                this.bonCode = bonCode;
        }

        public int getBookingIdForCommercialFGesture() {
                return bookingIdForCommercialFGesture;
        }

        public void setBookingIdForCommercialFGesture(int bookingIdForCommercialFGesture) {
                this.bookingIdForCommercialFGesture = bookingIdForCommercialFGesture;
        }
}
