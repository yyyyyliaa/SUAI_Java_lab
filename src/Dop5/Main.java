package Dop5;

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle(5, "krug", new Point(2,3), 1);
        Segment s = new Segment(new Point(0,0), new Point(2,2), new Point(1,1), 2);

        FigureList fList = new FigureList();
        fList.add(c);
        fList.addToHead(s);
        fList.printAll();

        Figure f = fList.findFigure(1);
        System.out.println("Find figure with id 1:");
        f.print();
        System.out.println();

        fList.erase(2);
        System.out.println("FigureList after erase figure with id 2:");
        fList.printAll();





    }
}
