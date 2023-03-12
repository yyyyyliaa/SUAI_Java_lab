package Lab5;

public class SparseMatrixElement {
    private int column;
    private double value;

    public SparseMatrixElement(int column, double value) {
        this.column = column;
        this.value = value;
    }

    public int getColumn() {
        return column;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
