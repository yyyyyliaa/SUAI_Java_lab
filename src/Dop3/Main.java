package Dop3;

public class Main {
    public static void main(String[] args) {
        FourPartMatrix x  = new FourPartMatrix(2, 5);
        FourPartMatrix y = new FourPartMatrix(2, 2);

        x.setElement(0, 0, 1);
        x.setElement(0,1, 2);
        x.setElement(0, 2, 3);
        x.setElement(0, 3, 4);
        x.setElement(0,4,5);
        x.setElement(1,0, 6);
        x.setElement(1,1,7);
        x.setElement(1,2,8);
        x.setElement(1,3,9);
        x.setElement(1,4,10);

        System.out.println(x.toString());


    }
}
