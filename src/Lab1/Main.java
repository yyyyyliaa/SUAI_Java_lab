package Lab1;

public class Main{
    public static void main(String[] args) {

        Int x = new Int();

        x.increment();

        System.out.println("x = " + x);

        for(int i = 0; i<7; i++){
            System.out.print("x = x + x" + "\nx = ");
            x.add(x);
            System.out.println(x.toString() + "\n");

        }

        for (int i = 0; i<3;i++){
            System.out.print("x = x - 1" + "\nx = ");
            x.decrement();
            System.out.println(x.toString() + "\n");
        }

        for (int i = 0; i<3;i++){
            System.out.print("x = x + x" + "\nx = ");
            x.add(x);
            System.out.println(x.toString() + "\n");
        }

    }
}
