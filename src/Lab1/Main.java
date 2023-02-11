package Lab1;

public class Main{
    public static void main(String[] args) {
        
        Int x = new Int(1);
        Int y = new Int(11);
        System.out.println("x = " + x);
        System.out.println("y = " + y + "\n");

        System.out.print("x = x + y" + "\nx = ");
        x.add(y);
        System.out.println(x.toString() + "\n");

        System.out.print("x = x - 1" + "\nx = ");
        x.decrement();
        System.out.println(x.toString() + "\n");

        System.out.print("y = y + 1" + "\ny = ");
        y.increment();
        System.out.println(y.toString() + "\n");

        System.out.print("x = x - y" + "\nx = ");
        x.subtract(y);
        System.out.println(x.toString() + "\n");
    }
}

//Команды для запуска из командной строки:
//javac -sourcepath ./src -d out src/Lab1/Main.java
//java -classpath ./out Lab1.Main