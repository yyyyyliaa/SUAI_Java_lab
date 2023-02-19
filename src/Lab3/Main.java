package Lab3;

public class Main {
    public static void main(String[] args) {
        SquareMatrix x = new SquareMatrix(2);
        SquareMatrix y = new SquareMatrix(2);

        x.setElement(0, 0, 1);
        x.setElement(0, 1, 10);
        x.setElement(1, 0, 2);
        x.setElement(1, 1, 9);

        y.setElement(0, 0, 1);
        y.setElement(0, 1, 0);
        y.setElement(1, 0, 11);
        y.setElement(1, 1, 8);

        System.out.println("First matrix:");
        System.out.println(x.toString() + "\n");

        System.out.println("Second matrix:");
        System.out.println(y.toString() + "\n");

        SquareMatrix z = x.sum(y);

        System.out.println("z = x + y \nz =");
        System.out.println(z.toString() + "\n");

        System.out.println("x = z");
        x = z;
        System.out.println(x.toString() + "\n");

        System.out.print("x equals y : ");
        System.out.println(x.equals(y) + "\n");

        try{
            int element = x.getElement(3, 10);
        }catch (MatrixActionException e){
            System.out.println(e.getMessage());
        }

    }
}
