package Dop3;

import Lab3.Matrix;
import Lab3.MatrixActionException;

import java.util.Arrays;

public class FourPartMatrix {
    private int partRowCount;
    private int partColumnCount;

    private int[][] part;
    private final int[][] data;

    public FourPartMatrix(int partRowCount, int partColumnCount){
        this.partRowCount = partRowCount;
        this.partColumnCount = partColumnCount;
        this.part = new int[partRowCount][partColumnCount];
        this.data = new int[partRowCount*2][partColumnCount*2];
    }

    public void setElement(int row, int column, int value) throws MatrixActionException{
        if(row<partRowCount && column<partColumnCount){
            data[row][column] = value;
            data[row+partRowCount][column] = value;
            data[row][column + partColumnCount] = value;
            data[row+partRowCount][column + partColumnCount] = value;
        } else throw new MatrixActionException("Beyond the Matrix");

    }

    public int getElement(int row, int column){
        return this.data[row][column];
    }

    public Matrix sum(Matrix matrix) throws SumMatrixException {
        if (this.partRowCount*2 != matrix.getRowsCount() || this.partColumnCount*2 != matrix.getColumnsCount()) {
            throw new SumMatrixException("Addition not possible: matrices must have the same size");
        }

        Matrix result = new Matrix(matrix.getRowsCount(), matrix.getColumnsCount());

        for (int i = 0; i < matrix.getRowsCount(); i++) {
            for (int j = 0; j < matrix.getColumnsCount(); j++) {
                result.setElement(i, j, this.data[i][j] + matrix.getElement(i, j));
            }
        }
        return result;
    }

    public Matrix product(Matrix matrix) throws ProductMatrixException{
        if (this.partColumnCount*2 != matrix.getRowsCount()) {
            throw new ProductMatrixException("Multiplication is not possible: the number of rows of the first matrix does not match the number of columns of the second matrix ");
        }

        Matrix result = new Matrix(this.partRowCount*2, matrix.getColumnsCount());

        for (int i = 0; i < this.partRowCount*2; i++) {
            for (int j = 0; j < matrix.getColumnsCount(); j++) {
                for (int k = 0; k < this.partColumnCount*2; k++) {
                    result.setElement(i, j, result.getElement(i,j) + (this.data[i][k] * matrix.getElement(k, j)));
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : this.data) {
            sb.append(Arrays.toString(row));
            sb.append("\n");
        }
        return sb.toString();
    }





}
