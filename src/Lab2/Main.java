package Lab2;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(2);
        matrix.setElement(0,0,1);
        matrix.setElement(0,1,1);
        matrix.setElement(1,0,1);
        matrix.setElement(1,1,0);

        System.out.println("Source matrix:");
        System.out.println(matrix);

        for (int i = 2; i<=10; i++){
            matrix = matrix.product(matrix);
            System.out.println("Matrix in " + i + " power:");
            System.out.println(matrix);
        }


    }
}
