package Lab5;

import java.util.LinkedList;

public class SparseMatrixRow {
    private int row;
    private LinkedList<SparseMatrixElement> elements;

    public SparseMatrixRow(int row) {
        this.row = row;
        elements = new LinkedList<SparseMatrixElement>();
    }

    public int getRow() {
        return row;
    }

    public LinkedList<SparseMatrixElement> getElements() {
        return elements;
    }

    public void addElement(SparseMatrixElement element) {
        elements.add(element);
    }
}
