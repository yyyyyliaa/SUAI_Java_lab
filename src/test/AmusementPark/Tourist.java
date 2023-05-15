package test.AmusementPark;

public class Tourist {
    private final int id;
    private final int time;

    public Tourist(int id, int time) {
        this.id = id + 1;
        this.time = time;
    }

    public int getId() {
        return this.id;
    }

    public int getTime() {
        return time;
    }
}
