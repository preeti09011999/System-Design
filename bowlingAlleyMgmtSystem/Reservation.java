
import java.util.Date;

public class Reservation {
    String reservationId;
    Customer customer;
    Lane lane;
    Date startTime;
    Date endTime;

    public Reservation(String reservationId, Customer customer, Lane lane, Date startTime, Date endTime) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.lane = lane;
        this.startTime = startTime;
        this.endTime = endTime;
    }    

}
