package test.AmusementPark;


/*иммитация парка птракционов, можно задать кол-во аттракционов,
 рандомным образом люди выбирают аттракцион и встают в очередь,
 у каждого чел. будет свой порядковый номер,
 атракцион будет выводить номер человека на нем каждый атракцион потов, обслуживающий*/



import Dop9.InternetCafe;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class AmusementPark {
    Queue<Tourist> touristsQueue;
    Attraction[] attractions;
    Threads[] threads;
    int numberOfTourists;
    int freeAttractions;
    int numberOfAttractions;

    public AmusementPark(int countOfAttractions, int countOfTourists, int session) {
        touristsQueue = new ArrayDeque<>(countOfTourists);
        numberOfTourists = countOfTourists;
        freeAttractions = countOfAttractions;
        numberOfAttractions = countOfAttractions;

        attractions = new Attraction[countOfAttractions];
        for (int i = 0; i < countOfTourists; i++) {
            touristsQueue.add(new Tourist(i, session));
        }

        for(int i = 0; i<countOfAttractions; i++){
            attractions[i] = new Attraction(i);
        }


        threads = new Threads[countOfAttractions];
    }

    public synchronized void freeAttraction() throws InterruptedException {
        notify();
    }

//    public synchronized void go() throws InterruptedException {
//        for (int i = 0; i < numberOfAttractions; i++) {
////            Random rand = new Random();
//            attractions[i] = new Attraction(i, touristsQueue.peek());
//            touristsQueue.remove();
//            threads[i] = new Threads(attractions[i], this);
//            if (freeAttractions == 0 && touristsQueue.peek()!=null)
//                System.out.println("Tourist №" + touristsQueue.peek().getId() + " waiting for turn");
//
//            while (freeAttractions == 0)
//                wait();
//
//            freeAttractions--;
//            System.out.println("Attraction № " + attractions[i].getId() + "occupied by tourist № " + attractions[i].getTourist().getId());
//
//            threads[i].start();
//        }
//
//        while (freeAttractions != numberOfAttractions)
//            wait();
//
//        for (Threads th : threads)
//            th.join();
//
//        System.out.println("All attractions are free!");
//    }
//public synchronized void go() throws InterruptedException {
//    while(touristsQueue.peek()!=null){
//        for (int i = 0; i < numberOfAttractions; i++) {
//            if(!attractions[i].getStatus()){
//                attractions[i] = new Attraction(i, touristsQueue.peek());
//                touristsQueue.remove();
//                threads[i] = new Threads(attractions[i], this);
//                freeAttractions--;
//                System.out.println("Attraction № " + attractions[i].getId() + "occupied by tourist № " + attractions[i].getTourist().getId());
//
//                threads[i].start();
//                break;
//            }
//
//        }
//        if (freeAttractions == 0 && touristsQueue.peek()!=null)
//            System.out.println("Tourist №" + touristsQueue.peek().getId() + " waiting for turn");
//
//        while (freeAttractions == 0)
//            wait();
//    }
//    while (freeAttractions != numberOfAttractions)
//        wait();
//
//    for (Threads th : threads)
//        th.join();
//
//    System.out.println("All attractions are free!");
//}

    public synchronized void go() throws InterruptedException {
        for (int i = 0; i < numberOfAttractions; i++) {
            threads[i] = new Threads(attractions[i], this);
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

        for (InternetCafe.Threads th : threads)
            th.join();

        System.out.println("The place is empty, let's close up and go to the beach!");
    }

    class Threads extends Thread {
        AmusementPark park;
        int numberOfCurrentAttraction;
        Attraction currentAttraction;

        public Threads(Attraction a, AmusementPark park) {
            this.park = park;
            currentAttraction = a;
            numberOfCurrentAttraction = a.getId();
        }

        @Override
        public void run() {
            try {
                Thread.sleep(currentAttraction.getTourist().getTime());

                System.out.println("Attraction №" + numberOfCurrentAttraction + " is free");
                touristsQueue.remove(currentAttraction.getTourist());

                freeAttractions++;

                freeAttraction();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
