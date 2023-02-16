package Dop1;

public class Interval {
    private final int leftLimit;
    private final int rightLimit;

    public Interval(int leftLimit, int rightLimit){
        this.leftLimit = leftLimit;
        this.rightLimit = rightLimit;
    }

    public Interval(String interval){
        if(interval.charAt(0) == '[') leftLimit = interval.charAt(1) - '0';
        else leftLimit = interval.charAt(1) - '0' - 1;

        if(interval.charAt(4) == '[') rightLimit = interval.charAt(3) - '0';
        else rightLimit = interval.charAt(3) - '0' - 1;
    }

    public int getLeftLimit(){
        return leftLimit;
    }

    public int getRightLimit(){
        return rightLimit;
    }

    public boolean intersect(Interval i){
        return (leftLimit <= i.getRightLimit()) && (rightLimit >= i.getLeftLimit());
    }
//
    public boolean intersect(int x, int y){
        return (leftLimit <= y) && (rightLimit >= x);
    }

    public boolean belongs(int x){
        return (x >= leftLimit) && (x <= rightLimit);
    }

}
