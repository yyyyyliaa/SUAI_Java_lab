package Dop8;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        long start1 = System.currentTimeMillis();
        Backpack backpack = new Backpack(100);
        backpack.solve(0, 100, 0);
        backpack.printPriceBestBackpack();
        long end1 = System.currentTimeMillis();
        long time = (end1 - start1);
        System.out.println("time: " + time + " ms");

        long start2 = System.currentTimeMillis();
        System.out.println(backpack.solveWithThreads(7));
        long end2 = System.currentTimeMillis();
        time = (end2 - start2);
        System.out.println("time: " + time + " ms");
    }

}

