package elevatorSystem;

import java.util.List;

public class RequestManager {
    List<Request> requestQueue;

    public RequestManager(){
        this.requestQueue = new ArrayList<>();
    }

    public void addRequest(Request request){
        requestQueue.add(request);
    }

    public List<Request> getRequest(){
        return new ArrayList<>(requestQueue);
    }

    public void clearRequest(Request request){
        requestQueue.remove(request);
    }
}
