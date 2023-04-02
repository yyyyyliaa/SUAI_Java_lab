package Dop7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Tree {
    Integer val = null;
    Tree l = null;
    Tree r = null;

    public Tree(){}

    public void loadFromTextFile(String path) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(path));
        String line = in.readLine();
        in.close();

        String[] rowData = line.split(" ");
        for (String rowDatum : rowData) {
            this.add(Integer.parseInt(rowDatum));
        }
    }

    public void saveToTextFile(String path) throws IOException {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(path));
            out.println(this.toString());
            out.flush();
            out.close();
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public void add(int val){
        if(this.val == null){
            this.val = val;
        } else{
            if(val>this.val) {
                if(this.r == null){
                    this.r = new Tree();
                    this.r.add(val);
                } else {
                    this.r.add(val);
                }
            }
            else {
                if(this.l == null){
                    this.l = new Tree();
                    this.l.add(val);
                }
                else this.l.add(val);
            }
        }
    }

    public int deepTree(){
        int deepR = 0;
        int deepL= 0;

        if (this.l != null) {
            deepL = this.l.deepTree();
            deepL++;

        }
        if (this.r != null) {
            deepR = this.r.deepTree();
            deepR++;
        }
        return Math.max(deepL,deepR);
    }

    public void printTree(int shift){
        if(this.l != null) this.l.printTree(shift+10);
        for (int i = 0; i<shift; i++){
            System.out.print(" ");
        }

        if(this.val != null) System.out.println(val);

        if(this.r != null) this.r.printTree(shift+10);
    }

    public void saveToBinaryFile(String path) throws IOException {
        Path p = Paths.get(path);
        try {
            Files.writeString(p, this.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromBinaryFile(String path) throws IOException {
        try {
            byte[] content = Files.readAllBytes(Paths.get(path));
            String line = new String(content);
            String[] rowData = line.split(" ");
            for (String rowDatum : rowData) {
                this.add(Integer.parseInt(rowDatum));
            }
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.val).append(" ");
        if (this.l != null) sb.append(this.l.toString());
        if (this.r != null) sb.append(this.r.toString());

        return sb.toString();
    }
}
