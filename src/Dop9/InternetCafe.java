package Dop9;

import java.util.*;

public class InternetCafe {
    Queue<Tourist> computerQueue;
    Tourist[] tourists;
    Threads[] threads;
    int numberOfTourists;
    int freeComputers;
    int numberOfComputers;

    public InternetCafe(int n, int m, int limitOfTouristTime) {
        computerQueue = new ArrayDeque<>(n);
        numberOfTourists = m;
        freeComputers = n;
        numberOfComputers = n;

        Random rand = new Random();
        tourists = new Tourist[m];
        for (int i = 0; i < m; i++)
            tourists[i] = new Tourist(i, rand.nextInt(limitOfTouristTime));

        threads = new Threads[m];
    }

    public synchronized void giveComp() throws InterruptedException {
        notify();
    }

    public synchronized void go() throws InterruptedException {
        for (int i = 0; i < numberOfTourists; i++) {
            threads[i] = new Threads(tourists[i], this);
            if (freeComputers == 0)
                System.out.println("Tourist №" + tourists[i].getId() + " waiting for turn");

            while (freeComputers == 0)
                wait();

            computerQueue.add(tourists[i]);
            freeComputers--;
            System.out.println("Tourist №" + tourists[i].getId() + " is online");

            threads[i].start();
        }

        while (freeComputers != numberOfComputers)
            wait();

        for (Threads th : threads)
            th.join();

        System.out.println("The place is empty, let's close up and go to the beach!");
    }

    class Threads extends Thread {
        InternetCafe cafe;
        int numberOfCurrentTourist;
        Tourist currentTourist;

        public Threads(Tourist t, InternetCafe cafe) {
            this.cafe = cafe;
            currentTourist = t;
            numberOfCurrentTourist = t.getId();
        }

        @Override
        public void run() {
            try {
                Thread.sleep(currentTourist.getTime());

                System.out.println("Tourist №" + numberOfCurrentTourist + " is done (having spent " + (currentTourist.getTime() / 50) + " seconds online)");

                computerQueue.remove(currentTourist);

                freeComputers++;

                giveComp();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
