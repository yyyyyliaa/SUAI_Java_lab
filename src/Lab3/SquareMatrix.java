package Lab3;

public class SquareMatrix extends Matrix{

    public SquareMatrix(int size){
        super(size);
        for(int i = 0; i<size; i++){
            this.data[i][i] = 1;
        }
    }

    public SquareMatrix sum(SquareMatrix tmp) throws MatrixActionException{
        if (this.rows != tmp.rows) throw new MatrixActionException("Addition not possible: matrices must have the same size");
        else{
            SquareMatrix res = new SquareMatrix(this.rows);
            for(int i = 0; i<rows; i++){
                for(int j = 0; j<rows; j++)
                    res.data[i][j] = this.data[i][j] + tmp.data[i][j];
            }
            return res;
        }
    }
}
