package Dop5;

import com.sun.source.tree.BreakTree;

public abstract class Figure {
    protected Point coord;
    protected int id;

    public Figure(Point coord, int id){
        this.coord = coord;
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public abstract void print();

}
