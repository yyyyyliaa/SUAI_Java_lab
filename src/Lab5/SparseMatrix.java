package Lab5;

import java.util.Arrays;
import java.util.LinkedList;

public class SparseMatrix extends Matrix {
    private LinkedList<SparseMatrixRow> rows;

    public SparseMatrix(int rows, int columns) {
        super(rows, columns);
        this.rows = new LinkedList<SparseMatrixRow>();
    }

    public SparseMatrix(int size) {
        this(size, size);
    }

    public double getElement(int row, int column) {
        for (SparseMatrixRow currentRow : rows) {
            if (currentRow.getRow() == row) {
                for (SparseMatrixElement element : currentRow.getElements()) {
                    if (element.getColumn() == column) {
                        return element.getValue();
                    }
                }
                return 0;
            }
        }
        return 0;
    }

    public void setElement(int row, int column, double value) {
        for (SparseMatrixRow currentRow : rows) {
            if (currentRow.getRow() == row) {
                for (SparseMatrixElement element : currentRow.getElements()) {
                    if (element.getColumn() == column) {
                        element.setValue(value);
                        return;
                    }
                }
                currentRow.addElement(new SparseMatrixElement(column, value));
                return;
            }
        }
        SparseMatrixRow newRow = new SparseMatrixRow(row);
        newRow.addElement(new SparseMatrixElement(column, value));
        rows.add(newRow);
    }

    public SparseMatrix add(SparseMatrix matrix) {
        return (SparseMatrix) super.add(matrix);
    }

    public SparseMatrix product(SparseMatrix matrix) {
        return (SparseMatrix) super.product(matrix);
    }

    public Matrix createMatrix(int rows, int columns) {
        return new SparseMatrix(rows, columns);
    }

    @Override //TODO: перекрыть toString() для класса SparseMatrix
    public String toString(){
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }
}


