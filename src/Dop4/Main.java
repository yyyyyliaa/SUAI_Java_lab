package Dop4;

public class Main {
    public static void main(String[] args) {
        SortedIntegerList list = new SortedIntegerList(false);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("List: " + list.toString() );
        System.out.println("Index of 2: " + list.find(2));
        System.out.println("Index of 6: " + list.find(6));
    }
}
