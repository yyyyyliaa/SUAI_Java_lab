package Dop1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.print("Enter interval: ");
//        Scanner scanner = new Scanner(System.in);
//        String interval = scanner.nextLine();
//        scanner.close();

        Interval i = new Interval(12,40);
        System.out.println(i.getLeftLimit() + " " + i.getRightLimit());

        int x = 5;
        System.out.println(x + " belong interval:" + i.belongs(x));

        Interval j = new Interval(3,11);

        System.out.println("Intersection of intervals [3;11]: " + i.intersect(j));
    }
}
