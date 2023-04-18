package Dop8;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        long start1 = System.currentTimeMillis();
        int maxWeight = 70;
        Backpack backpack = new Backpack(maxWeight);
        backpack.solve(0, maxWeight, 0);
        System.out.print("Max price:");
        backpack.printPriceBestBackpack();
        long end1 = System.currentTimeMillis();
        long time = (end1 - start1);
        System.out.println("1 Thread: time: " + time + " ms");

        long start2 = System.currentTimeMillis();
        int countOfThreads = 7;
        System.out.print("Max price:");
        System.out.println(backpack.solveWithThreads(countOfThreads));
        long end2 = System.currentTimeMillis();
        time = (end2 - start2);
        System.out.println(countOfThreads + " Thread: time: " + time + " ms");
    }

}

