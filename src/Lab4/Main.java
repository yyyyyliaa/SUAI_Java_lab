package Lab4;

public class Main {
    public static void main(String[] args) {
        SortedIntegerList listWithoutDuplicates = new SortedIntegerList(false);
        SortedIntegerList listWithDuplicates = new SortedIntegerList(true);

        listWithoutDuplicates.add(1);
        listWithoutDuplicates.add(1);
        listWithoutDuplicates.add(2);
        listWithoutDuplicates.add(3);

        listWithDuplicates.add(1);
        listWithDuplicates.add(1);
        listWithDuplicates.add(2);
        listWithDuplicates.add(3);

        System.out.println("List1 (without duplicates) :" + listWithoutDuplicates.toString());
        System.out.println("List2 (with duplicates) :" + listWithDuplicates.toString());

        System.out.println("List1 equals List2: " + listWithDuplicates.equals(listWithoutDuplicates));

        listWithoutDuplicates.remove(1);
        System.out.println("List1 after remove 1: " + listWithoutDuplicates.toString());

        listWithDuplicates.remove(1);
        listWithDuplicates.remove(1);
        System.out.println("List2 after double remove 1: " + listWithDuplicates.toString());

        System.out.println("List1 equals List2: " + listWithDuplicates.equals(listWithoutDuplicates));


    }
}
