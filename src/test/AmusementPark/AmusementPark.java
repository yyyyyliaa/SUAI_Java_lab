package test.AmusementPark;


import java.util.ArrayDeque;
import java.util.Queue;

public class AmusementPark {
    Queue<Tourist> touristsQueue;
    Threads[] threads;
    Tourist[] tourists;
    int numberOfTourists;
    int freeAttractions;
    int numberOfAttractions;

    public AmusementPark(int countOfAttractions, int countOfTourists, int session) {
        touristsQueue = new ArrayDeque<>(countOfTourists);
        numberOfTourists = countOfTourists;
        freeAttractions = countOfAttractions;
        numberOfAttractions = countOfAttractions;

        tourists = new Tourist[countOfTourists];
        for (int i = 0; i < countOfTourists; i++) {
            tourists[i] = new Tourist(i, session);
        }

        threads = new Threads[countOfTourists];
    }

    public synchronized void freeAttraction() throws InterruptedException {
        notify();
    }

    public synchronized void go() throws InterruptedException {
        for (int i = 0; i < numberOfTourists; i++) {
            threads[i] = new Threads(tourists[i], this);
            if (freeAttractions == 0)
                System.out.println("Tourist №" + tourists[i].getId() + " waiting for turn");

            while (freeAttractions == 0)
                wait();

            touristsQueue.add(tourists[i]);
            freeAttractions--;
            System.out.println("Tourist №" + tourists[i].getId() + " is on attraction");

            threads[i].start();
        }

        while (freeAttractions != numberOfAttractions)
            wait();

        for (Threads th : threads)
            th.join();

        System.out.println("All attractions are free!!! The queue is empty!!!");
    }
    class Threads extends Thread {
        AmusementPark park;
        int numberOfCurrentTourist;
        Tourist currentTourist;

        public Threads(Tourist t, AmusementPark park) {
            this.park = park;
            currentTourist = t;
            numberOfCurrentTourist = t.getId();
        }

        @Override
        public void run() {
            try {
                Thread.sleep(currentTourist.getTime());

                System.out.println("Tourist №" + numberOfCurrentTourist + " is done");

                touristsQueue.remove(currentTourist);

                freeAttractions++;

                freeAttraction();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
