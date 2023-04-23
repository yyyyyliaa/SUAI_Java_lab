package Dop9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter count of computers: ");
        int n = sc.nextInt();

        System.out.print("Enter count of tourists: ");
        int m = sc.nextInt();

        InternetCafe cafe = new InternetCafe(n, m, 10000);

        try {
            cafe.go();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
