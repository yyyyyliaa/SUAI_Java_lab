package Dop8;

import java.nio.channels.NotYetBoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backpack {
    private Item[] it = {new Item("item1", 1, 8000),
                new Item("item2", 2, 3000),
                new Item("item3", 3, 2000),
                new Item("item4", 3, 6000),
                new Item("item5", 8, 2500),
                new Item("item6", 5, 5000),
                new Item("item7", 11, 11000)};
    List<Item> items = new ArrayList<>(Arrays.asList(it));
    private final int[] curBackpack = new int[items.size()];
    private int[] bestBackpack = new int[items.size()];
    private int bestPrice = 0;
    private int maxWeight = 0;


    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void printPriceBestBackpack() {
        System.out.println(calcPrice(bestBackpack));
    }

    //вычисляет общий вес набора предметов
    private int calcWeight(int[] bp) {
        int result = 0;
        for (int i = 0; i < bp.length; i++) {
            for (int j = 0; j < bp[i]; j++) {
                result += items.get(i).getWeight();
            }
        }
        return result;
    }

    // вычисляет общую стоимость набора предметов
    private int calcPrice(int[] bp) {
        int result = 0;
        for (int i = 0; i < bp.length; i++) {
            for (int j = 0; j < bp[i]; j++) {
                result += items.get(i).getPrice();
            }
        }
        return result;
    }

    public int solveWithThreads(int numThreads) throws InterruptedException {
        MyThread[] threads = new MyThread[numThreads];
        int startIndex, endIndex;
        int blockSize = items.size() / numThreads;

        for (int i = 0; i < numThreads; i++) {
            startIndex = i * blockSize;
            if(i==numThreads-1) endIndex = items.size();
            else endIndex = (i+1)*blockSize;
            threads[i] = new MyThread(startIndex, endIndex);
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
        }

        return bestPrice;
    }

    public void solve(int i, int curWeight, int curPrice) {
        if (i == items.size()) {
            if (curPrice > bestPrice) {
                bestPrice = curPrice;
                bestBackpack = Arrays.copyOf(curBackpack, items.size());
            }
        } else {
            int limit = curWeight / items.get(i).getWeight();
            for (int j = 0; j <= limit; j++) {
                curBackpack[i] = j;
                solve(i + 1, curWeight - j * items.get(i).getWeight(), curPrice + j * items.get(i).getPrice());
            }
        }
    }

    private class MyThread extends Thread {
        int startIndex;
        int endIndex;

        public MyThread(int start, int end) {
            this.startIndex = start;
            this.endIndex = end;
        }

        public void run() {
            int[][] dp = new int[endIndex - startIndex + 1][maxWeight + 1];
            for (int i = 0; i <= maxWeight; i++) {
                dp[0][i] = 0;
            }

            for (int i = 1; i <= endIndex - startIndex; i++) {
                for (int j = 0; j <= maxWeight; j++) {
                    dp[i][j] = dp[i - 1][j];

                    if (j >= items.get(startIndex + i - 1).getWeight()) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - items.get(startIndex + i - 1).getWeight()] + items.get(startIndex + i - 1).getPrice());
                    }

                    if (dp[i][j] > bestPrice) {
                        bestPrice = dp[i][j];
                    }
                }
            }

        }
    }
}