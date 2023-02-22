package Dop2;

import java.util.Arrays;

public class Matrix {
    private final int size;
    private final int[][] data;

    public Matrix(int size){
        this.size = size;
        this.data = new int[size][size];
        for(int i = 0; i<size; i++){
            this.data[i][i] = 1;
        }
    }
    public Matrix(int size, int start){
        this.size = size;
        this.data = new int[size][size];
        int i = 1;
        for(int k = start; k < size; k++){
            for (int j = k-1; j < size-k+1; j++) data[k-1][j]=i++;
            for (int j = k; j < size-k+1; j++) data[j][size-k]=i++;
            for (int j = size-k-1; j >= k-1; j--) data[size-k][j]=i++;
            for (int j = size-k-1; j >= k; j--) data[j][k-1]=i++;
        }
    }
    public void setElement(int row, int column, int value){
        this.data[row][column] = value;
    }
    public long getElement(int row, int column){
        return this.data[row][column];
    }
    public Matrix sum(Matrix tmp){
        Matrix res = new Matrix(this.size);
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++)
                res.data[i][j] = this.data[i][j] + tmp.data[i][j];
        }
        return res;
    }

    public Matrix product(Matrix tmp){
        Matrix res = new Matrix(this.size);
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                int summa = 0;
                for (int k = 0; k < this.size; k++)
                    summa += this.data[i][k] * tmp.data[k][j];
                res.data[i][j] = summa;
            }
        }
        return res;
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
