package Lab5;

public class Main {
    public static void main(String[] args) {
        final int matrixSize = 5;
        final int elementsCount = 20;

        SquareMatrix sourceSquareMatrix = new SquareMatrix(matrixSize);
        SparseMatrix sourceSparseMatrix = new SparseMatrix(matrixSize);

        for (int j = 0; j < elementsCount; j++) {
            int row = (int) (Math.random() * matrixSize);
            int column = (int) (Math.random() * matrixSize);
            double value = Math.random() * 1000;
            sourceSquareMatrix.setElement(row, column, value);
            sourceSparseMatrix.setElement(row, column, value);
        }

        System.out.println("Source square matrix:");
        System.out.println(sourceSquareMatrix.toString() + "\n");

        System.out.println("Source sparse matrix:");
        System.out.println(sourceSparseMatrix.toString());


        System.out.println("Sum of Square matrices:");
        SquareMatrix sumSquareMatrix = new SquareMatrix(matrixSize);
        sumSquareMatrix = sourceSquareMatrix.add(sourceSquareMatrix);
        System.out.println(sumSquareMatrix.toString() + "\n");

        System.out.println("Sum of Sparse matrices: ");
        SparseMatrix sumSparseMatrix = new SparseMatrix(matrixSize);
        sumSparseMatrix = sourceSparseMatrix.add(sourceSparseMatrix);
        System.out.println(sumSparseMatrix.toString() + "\n");

        System.out.print("Source square matrix equals sum square matrix: ");
        System.out.println(sourceSquareMatrix.equals((Matrix) sumSquareMatrix)+ "\n");

        System.out.println("Product of square matrices: ");
        SquareMatrix productSquareMatrix = new SquareMatrix(matrixSize);
        productSquareMatrix = sourceSquareMatrix.product(sourceSquareMatrix);
        System.out.println(productSquareMatrix.toString()+ "\n");

        System.out.println("Product of sparse matrices: ");
        SparseMatrix productSparseMatrix = new SparseMatrix(matrixSize);
        productSparseMatrix = sourceSparseMatrix.product(sourceSparseMatrix);
        System.out.println(productSparseMatrix.toString() + "\n");
    }
}
