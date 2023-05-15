package test.AmusementPark;

import java.util.ArrayDeque;

public class Attraction {
    private final int id;
    private Tourist t;
    private boolean status;
    private final ArrayDeque<Tourist> touristsQueue = new ArrayDeque<>();


    public Attraction(int id) {
        this.id = id + 1;
        this.status = false;
    }

    public void updAttraction(Tourist t){
        this.t = t;
        this.status = true;
    }

    public int getId() {
        return this.id;
    }

    public Tourist getTourist(){
        return t;
    }

    public boolean getStatus(){
        return status;
    }

    public void addTouristInQueue(Tourist t){
        touristsQueue.add(t);
    }

    public ArrayDeque<Tourist> getQueue(){
        return touristsQueue;
    }

}
