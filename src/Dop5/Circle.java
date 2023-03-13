package Dop5;

public class Circle extends Figure{
    private int radius;
    private String signature;

    public Circle(int radius, String signature, Point startCoord, int id){
        super(startCoord, id);
        this.radius = radius;
        this.signature = signature;
    }

    public void print(){
        System.out.println("Circle " + id + " " + signature + ": radius = " + radius);;
    }

}
