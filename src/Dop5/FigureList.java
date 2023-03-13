package Dop5;

import java.util.LinkedList;

public class FigureList {
    private final LinkedList<Figure> figurs;

    public FigureList(){
        figurs = new LinkedList<>();
    }

    public void add(Figure f){
        figurs.add(f);
    }
    public void addToHead(Figure f){
        figurs.add(0, f);
    }

    public Figure findFigure(int id){
        for(Figure f : figurs){
            if(id==f.getId()) {
                return f;
            }
        }
        return null;
    }

    public void erase(int id){
        figurs.removeIf(f -> id == f.getId());
    }

    public void printAll(){
        for(Figure f : figurs){
            f.print();
        }
    }
}
