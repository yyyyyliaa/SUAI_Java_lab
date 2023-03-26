package Lab7;

import java.util.HashMap;
import java.io.*;
import java.nio.file.*;

public class Settings {
    private HashMap<String, Integer> settings;

    public Settings() {
        settings = new HashMap<String, Integer>();
    }

    public void put(String name, int value) {
        settings.put(name, value);
    }

    public int get(String name) {
        return settings.get(name);
    }

    public void delete(String name) {
        settings.remove(name);
    }

    public void saveToBinaryFile(String path) throws IOException {
        Path p = Paths.get(path);
        try {
            Files.writeString(p, this.settings.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromBinaryFile(String path) throws IOException {
        try {
              byte[] content = Files.readAllBytes(Paths.get(path));
              String line = new String(content);
              this.settings = new HashMap<String, Integer>();
              String[] pairs = line.substring(1, line.length()-1).split(", ");
              for (String pair : pairs) {
                  String[] keyValue = pair.split("=");
                  this.settings.put(keyValue[0], Integer.parseInt(keyValue[1]));
              }
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public void saveToTextFile(String path) throws IOException {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(path));
            out.println(this);
            out.flush();
            out.close();
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public void loadFromTextFile(String path) throws IOException {
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String line = in.readLine();
            in.close();
            this.settings = new HashMap<String, Integer>();
            String[] pairs = line.substring(1, line.length()-1).split(", ");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                this.settings.put(keyValue[0], Integer.parseInt(keyValue[1]));
            }
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;

        if (obj == null || obj.getClass() != this.getClass()) return false;

        Settings settings = (Settings) obj;
        return settings.settings.equals(this.settings);
    }
    @Override
    public String toString() {
        return settings.toString();
    }
}
