import java.util.Date;
import java.util.List;

public class Shipment {
    String shipmentNumber;
    Date shipmentDate;
    Date estimatedArrival;
    String shipmentMethod;
    List<ShipmentLog> shipmentLog;
    
    public void addShipmentLog(ShipmentLog shipmentLog){}
}
