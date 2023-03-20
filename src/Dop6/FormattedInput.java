package Dop6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FormattedInput {
    private static final Character[] hexDigits = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    private static final Character[] binDigits = {'0','1'};


    public static void main(String[] args) {
        Object[] test = scanf("%x %b");
        for (Object obj : test) {
            System.out.println(obj.getClass().getName() + ": " + obj.toString());
        }
    }
    private static final String[] valFormat = {
            "%d",
            "%f",
            "%s",
            "%c",
            "%x",
            "%b"
    };
    public static Object[] scanf(String format){
        Scanner sc = new Scanner(System.in);
        while (true){
            try {
                Object[] result = sscanf(format, sc.nextLine());
                sc.close();
                return result;
            } catch (Exception e) {
                System.out.println("Invalid Wrong format.\n" + "Please re-enter");
            }
        }
    }

    public static Object[] sscanf(String format, String in){
        String[] inputData = in.split(" ");
        Set<String> validFormats = new HashSet<>(Arrays.asList(valFormat));
        Set<String> inputFormats = new HashSet<>(Arrays.asList(format.split(" ")));
        Set<Character> validHexSymbols = new HashSet<>(Arrays.asList(hexDigits));
        Set<Character> validBinSymbols = new HashSet<>(Arrays.asList(binDigits));


        boolean formatIsValid;
        for(String f : inputFormats){
            formatIsValid = validFormats.contains(f);
            if(!formatIsValid){
                throw new IllegalArgumentException("Invalid format");
            }
        }

        Object[] result = new Object[inputData.length];
        int i = 0;
        for(String f : inputFormats){
            switch (f) {
                case "%d" -> result[i] = Integer.parseInt(inputData[i]);
                case "%f" -> result[i] = Double.parseDouble(inputData[i]);
                case "%s" -> result[i] = inputData[i];
                case "%c" -> {
                    if (inputData[i].length() != 1) {
                        throw new RuntimeException("Input does not match format");
                    } else {
                        result[i] = inputData[i].charAt(0);
                    }
                }
                case "%b" -> {
                    for(int j = 0; j<inputData[i].length(); j++){
                        if(!validBinSymbols.contains(inputData[i].charAt(j))){
                            throw new IllegalArgumentException("Invalid format");
                        }
                    }
                    BinaryNumber res = new BinaryNumber(inputData[i]);
                    result[i] = res;
                }
                case "%x" -> {
                    for(int j = 0; j<inputData[i].length(); j++){
                        if(!validHexSymbols.contains(inputData[i].charAt(j))){
                            throw new IllegalArgumentException("Invalid format");
                        }
                    }
                    HexadecimalNumber res = new HexadecimalNumber(inputData[i]);
                    result[i] = res;
                }
            }
            i++;
        }

        return result;
    }
}

    
