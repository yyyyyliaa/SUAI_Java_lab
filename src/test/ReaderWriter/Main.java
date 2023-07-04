package test.ReaderWriter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
            String[] filenames = {"/Users/yyyyyliaa/SUAI_Java_lab/src/test/ReaderWriter/1.txt", "/Users/yyyyyliaa/SUAI_Java_lab/src/test/ReaderWriter/2.txt", "/Users/yyyyyliaa/SUAI_Java_lab/src/test/ReaderWriter/3.txt", "/Users/yyyyyliaa/SUAI_Java_lab/src/test/ReaderWriter/4.txt"};

            ReaderWriter readerWriter = new ReaderWriter(filenames);

            readerWriter.scan();

            readerWriter.printMap();

    }
}