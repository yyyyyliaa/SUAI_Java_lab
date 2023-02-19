package Lab3;

import java.util.Arrays;

public class Matrix {
    protected int rows;
    protected int columns;
    protected int[][] data;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new int[rows][columns];
    }

    public Matrix(int size) {
        this(size, size);
    }

    public Matrix() {
        this(1, 1);
    }

    public Matrix sum(Matrix matrix) throws MatrixActionException {
        if (this.rows != matrix.rows || this.columns != matrix.columns) {
            throw new MatrixActionException("Addition not possible: matrices must have the same size");
        }

        Matrix result = new Matrix(this.rows, this.columns);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.data[i][j] = this.data[i][j] + matrix.data[i][j];
            }
        }

        return result;
    }

    public Matrix product(Matrix matrix) {
        if (this.columns != matrix.rows) {
            throw new MatrixActionException("Multiplication is not possible: the number of rows of the first matrix does not match the number of columns of the second matrix ");
        }

        Matrix result = new Matrix(this.rows, matrix.columns);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < matrix.columns; j++) {
                for (int k = 0; k < this.columns; k++) {
                    result.data[i][j] += this.data[i][k] * matrix.data[k][j];
                }
            }
        }

        return result;
    }

    public void setElement(int row, int column, int value) {
        if (row < 0 || row >= this.rows || column < 0 || column >= this.columns) {
            throw new MatrixActionException("Beyond the Matrix");
        }

        this.data[row][column] = value;
    }

    public int getElement(int row, int column) {
        if (row < 0 || row >= this.rows || column < 0 || column >= this.columns) {
            throw new MatrixActionException("Beyond the Matrix");
        }

        return this.data[row][column];
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;

        if (obj == null || obj.getClass() != this.getClass()) return false;

        Matrix m = (Matrix) obj;

        if (this.rows != m.rows || this.columns != m.columns) return false;

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (this.data[i][j] != m.data[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

