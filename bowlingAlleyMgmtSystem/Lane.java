public class Lane{
    int laneId;
    boolean isAvailable;
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    Reservation currentReservation;
    public Lane(int laneId) {
        //TODO Auto-generated constructor stub
        this.laneId = laneId;
        isAvailable = true;
        currentReservation = null;
    }

    boolean reserveLane(Reservation reservation){
        if(isAvailable){
            currentReservation = reservation;
            isAvailable = false;
            return true;
        }
        else return false;
    }

    void freeLane(){
        this.currentReservation = null;
        this.isAvailable = true;
    }

    boolean isAvailable() {
        return this.isAvailable;
    }
}