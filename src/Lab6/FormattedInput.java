package Lab6;

import java.util.*;

public class FormattedInput {

    public static void main(String[] args) {
        Object[] test = scanf("%c %s %d");
        for (Object obj : test) {
            System.out.println(obj.getClass().getName() + ": " + obj);
        }
    }
    private static final String[] valFormat = {
            "%d",
            "%f",
            "%s",
            "%c"
    };
    public static Object[] scanf(String format){
        Scanner sc = new java.util.Scanner(System.in);
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
            }
            i++;
        }

        return result;
    }
}

    
