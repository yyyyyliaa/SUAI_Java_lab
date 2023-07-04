package Lab6;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class EncodingConverter {

    public static void main(String[] args) {
//        if (args.length != 4) {
//            System.out.println("Invalid number of arguments");
//            return;
//        }
//
//        if (!args[0].matches(".*\\.txt") || !args[1].matches(".*\\.txt")) {
//            System.out.println("Invalid file path");
//            return;
//        }

        String[] arg = {"/Users/yyyyyliaa/SUAI_Java_lab/src/Lab6/in.txt", "/Users/yyyyyliaa/SUAI_Java_lab/src/Lab6/out.txt", "CP1251", "utf8"};


        String[] encodings = Charset.availableCharsets().keySet().toArray(new String[0]);
        ArrayList<String> charsets = new ArrayList<String>(Arrays.asList(encodings));
        for (String encoding : encodings) {
            charsets.addAll(Charset.availableCharsets().get(encoding).aliases());
        }

        for (int i = 2; i < 4; i++) {
            final int j = i;
            try {
                arg[j] = charsets.stream().filter(charset -> charset.equalsIgnoreCase(arg[j])).findFirst().get();
            } catch (Exception e) {
                System.out.println("Invalid encoding");
                return;
            }
        }

//        try {
            convert(arg[0], arg[1], arg[2], arg[3]);
//        } catch (IOException e) {
//            System.out.println("Error while converting file");
//        }
    }

    public static void convert(String inputFile, String outputFile, String firstEncoding, String secondEncoding) {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), firstEncoding));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), secondEncoding));
            String s;
            while((s = br.readLine()) != null){
                bw.write(s);
                bw.flush();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }



}
