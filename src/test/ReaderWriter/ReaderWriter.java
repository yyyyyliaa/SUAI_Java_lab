package test.ReaderWriter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class ReaderWriter {

    private final HashMap<String, Integer> map = new HashMap<>();
    private final MyThread[] myThreads;
    private final String[] fileNames;
    public ReaderWriter(String[] filenames) {
        fileNames = filenames;
        myThreads = new MyThread[filenames.length];
    }

    public void scan() throws InterruptedException {
        for (int i = 0; i < fileNames.length; i++) {
            myThreads[i] = new MyThread(new File(fileNames[i]));
            myThreads[i].start();
        }

        for (MyThread myThread : myThreads) {
            myThread.join();
        }

        for (MyThread myThread : myThreads) {
            HashMap<String, Integer> temp = myThread.getMap();

            for (Map.Entry entry : temp.entrySet()) {
                if (map.containsKey(entry.getKey())) {
                    map.put((String) entry.getKey(), (int) entry.getValue() + map.get(entry.getKey()));
                } else {
                    map.put((String) entry.getKey(), (Integer) entry.getValue());
                }
            }
        }

    }
    public void printMap() {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }



}
