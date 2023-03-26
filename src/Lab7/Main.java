package Lab7;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Settings sourceSettings = new Settings();

        sourceSettings.put("setting1", 1);
        sourceSettings.put("setting2", 2);
        sourceSettings.put("setting3", 3);
        sourceSettings.put("setting4", 4);


        sourceSettings.delete("setting1");
        sourceSettings.put("setting5", 5);

        try {
            sourceSettings.saveToBinaryFile("/Users/yyyyyliaa/SUAI_Java_lab/src/Lab7/test.bin");
            Settings settingsFromBinFile = new Settings();
            settingsFromBinFile.loadFromBinaryFile("/Users/yyyyyliaa/SUAI_Java_lab/src/Lab7/test.bin");
            System.out.println("Source settings: " + sourceSettings);
            System.out.print("Settings from bin file: ");
            System.out.println(settingsFromBinFile);
        } catch (IOException  e) {
            System.out.println(e.getMessage());
        }


        try {
            sourceSettings.saveToTextFile("/Users/yyyyyliaa/SUAI_Java_lab/src/Lab7/test.txt");
            Settings settingsFromTextFile = new Settings();
            settingsFromTextFile.loadFromTextFile("/Users/yyyyyliaa/SUAI_Java_lab/src/Lab7/test.txt");
            System.out.println("Source settings: " + sourceSettings);
            System.out.print("Settings from text file: ");
            System.out.println(settingsFromTextFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
