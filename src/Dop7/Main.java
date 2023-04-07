package Dop7;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Tree test = new Tree();
        test.loadFromTextFile("/Users/yyyyyliaa/SUAI_Java_lab/src/Dop7/test_in.txt");
        System.out.println("Tree from text file:");
        test.printTree(5);
        test.saveToTextFile("/Users/yyyyyliaa/SUAI_Java_lab/src/Dop7/test_out.txt");

        test.saveToBinaryFile("/Users/yyyyyliaa/SUAI_Java_lab/src/Dop7/test_out.bin");

        Tree test2 = new Tree();
        test2.loadFromBinaryFile("/Users/yyyyyliaa/SUAI_Java_lab/src/Dop7/test_out.bin");
        System.out.println("Tree from bin file:");
        test2.printTree(5);
    }
}
