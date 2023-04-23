package test.Library;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Library l1 = new Library();

        try{
            l1.loadFromTextFile("/Users/yyyyyliaa/SUAI_Java_lab/src/test/Library/in.txt");
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.print("Result of search '1984':");
        try {
            Book b = l1.findBook("1984");
            System.out.println(b.toString());
        } catch (BookException e){
            System.out.println(e.getMessage());
        }

        System.out.print("Result of search '1985':");
        try {
            Book b = l1.findBook("1985");
            System.out.println(b.toString());
        } catch (BookException e){
            System.out.println(e.getMessage());
        }


        Library l2 = new Library(l1.findAllBooksAfterYear(1950));

        try{
            l2.saveToTextFile("/Users/yyyyyliaa/SUAI_Java_lab/src/test/Library/out.txt");
        } catch (IOException e){
            e.printStackTrace();
        }


    }
}
