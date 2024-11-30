package elevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private List<Elevator> elevators;
    private RequestManager requestManager;

    public ElevatorController(){
        this.elevators = new ArrayList<>();
        this.requestManager = requestManager;
    }

    public void processrequests(){
        while (true) { 
            List<Request> requests = requestManager.getRequest();
            for(Request req : requests) {
                Elevator bestElevator = findBestElevator(req);
                if(bestElevator != null){
                    bestElevator.addRequest(req.floor);
                    requestManager.clearRequest(req);
                }
            }
            // move each elevator
            for(Elevator ele : elevators){
                ele.move();
            }

            try {
                Thread.sleep(100);
                // Without Thread.sleep, the loop in the controller would run continuously at full speed, consuming 
                // unnecessary CPU resources. Adding a delay allows the system to:
                // Pause briefly between iterations.
                // Free up CPU resources for other tasks

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public Elevator findBestElevator(Request request){
        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;
        for(Elevator ele : this.elevators){
            if(ele.isIdle) return ele;
            int dis = Math.abs(ele.currentFloor - request.floor);
            if(dis < minDistance){
                minDistance = dis;
                bestElevator = ele;
            }
        }
        return bestElevator;
    }
}
