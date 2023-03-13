package Dop5;

public class Segment extends Figure{
    private Point startCoord;
    private Point endCoord;

    public Segment(Point startCoord, Point endCoord, Point coord, int id){
        super(coord, id);
        this.startCoord = startCoord;
        this.endCoord = endCoord;
    }

    public void print(){
        System.out.println("Segment " + id + " (" + startCoord.getCoordX() + ";" + startCoord.getCoordY() + ") (" + endCoord.getCoordX() + ";" + endCoord.getCoordY() + ")" ) ;
    }
}
