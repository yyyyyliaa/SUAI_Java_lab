package Dop5;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setCoord(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getCoordX(){
        return this.x;
    }

    public int getCoordY(){
        return this.y;
    }
}
