package Lab8;

import Lab5.Matrix;

import java.util.Arrays;

public class UsualMatrix extends Matrix {
    private double[][] data;

    public UsualMatrix(int size) {
        super(size, size);
        data = new double[size][size];
    }

    public UsualMatrix(int rows, int columns) {
        super(rows, columns);
        data = new double[rows][columns];
    }

    public double getElement(int row, int column) {
        return data[row][column];
    }

    public void setElement(int row, int column, double value) {
        data[row][column] = value;
    }

    public UsualMatrix add(UsualMatrix matrix) {
        return (UsualMatrix) super.add(matrix);
    }

    public UsualMatrix product(UsualMatrix matrix) {
        return (UsualMatrix) super.product(matrix);
    }

    @Override
    public Matrix createMatrix(int rows, int columns) {
        return new UsualMatrix(rows, columns);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] row : this.data) {
            sb.append(Arrays.toString(row));
            sb.append("\n");
        }
        return sb.toString();
    }
}

