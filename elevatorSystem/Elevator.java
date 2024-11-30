package elevatorSystem;

import java.util.TreeSet;

public class Elevator {
    int currentFloor;
    int id;
    Direction direction;
    TreeSet<Integer> upQueue;
    TreeSet<Integer> downQueue;
    Direction direction;
    boolean isIdle;

    // constructor
    public Elevator(int id){
        this.id = id;
        this.currentFloor = 0;
        isIdle = true;
        this.direction = Direction.IDLE;
        upQueue = new TreeSet<>();
        downQueue = new TreeSet<>((a, b) -> b-a);
    }

    public void addRequest(int floor){
        if(this.currentFloor < floor){
            // upQueue
            upQueue.add(floor);
        }
        else if(this.currentFloor > floor) downQueue.add(floor);
    }

    public void move(){
        if(direction == Direction.UP){
            if(!upQueue.isEmpty()){
                currentFloor = upQueue.pollFirst();
            }
            else if(!downQueue.isEmpty()){
                currentFloor = downQueue.pollFirst();
                direction = Direction.DOWN;
            }
            else {
                direction = Direction.IDLE;
                isIdle = true;
            }
        }
        else if(direction == Direction.DOWN){
            if(!downQueue.isEmpty()){
                currentFloor = downQueue.pollFirst();
            }
            else if(!upQueue.isEmpty()){
                currentFloor = upQueue.pollFirst();
                direction = Direction.DOWN;
            }
            else {
                direction = Direction.IDLE;
                isIdle = true;
            }
        }
        else{
            if(!upQueue.isEmpty()){
                direction = Direction.UP;
                currentFloor = upQueue.pollFirst();
            }
            else if(!downQueue.isEmpty()){
                direction = Direction.DOWN;
                currentFloor = downQueue.pollFirst();
            }
        }

    }
}
