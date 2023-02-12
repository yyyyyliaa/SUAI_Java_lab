package Lab2;

import java.util.Arrays;

public class Matrix {
    private final int size;
    private final int[][] matrix;

    public Matrix(int size){
        this.size = size;
        this.matrix = new int[size][size];
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                if(i == j)
                    this.matrix[i][j] = 1;
                else this.matrix[i][j] = 0;
            }
        }
    }
    public void setElement(int row, int column, int value){
        this.matrix[row][column] = value;
    }
    public long getElement(int row, int column){
        return this.matrix[row][column];
    }
    public Matrix sum(Matrix tmp){
        Matrix res = new Matrix(this.size);
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++)
                res.matrix[i][j] = this.matrix[i][j] + tmp.matrix[i][j];
        }
        return res;
    }

    public Matrix product(Matrix tmp){
        Matrix res = new Matrix(this.size);
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                res.matrix[i][j] = 0;
                for (int k = 0; k < this.size; k++)
                    res.matrix[i][j] += this.matrix[i][k] * tmp.matrix[k][j];

            }
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : this.matrix) {
            sb.append(Arrays.toString(row));
            sb.append("\n");
        }
        return sb.toString();
    }

}
