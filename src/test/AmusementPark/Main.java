package test.AmusementPark;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter count of attraction: ");
//        int countOfAttractions = sc.nextInt();
//
//        System.out.print("Enter count of tourists: ");
//        int countOfTourists = sc.nextInt();

//        AmusementPark park = new AmusementPark(countOfAttractions, countOfTourists, 10);
        AmusementPark park = new AmusementPark(5, 10, 1000);

        try {
            park.go();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
