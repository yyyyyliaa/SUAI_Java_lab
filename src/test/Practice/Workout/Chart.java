package test.Practice.Workout;

import javax.swing.*;
import java.awt.*;

public class Chart extends JFrame {
    public  int[] x;
    public  int[] y;
    public int n;

    public Chart (int[] x, int[] y, int n) {
        super("Results");
        this.x = x;
        this.y = y;
        this.n = n;
        JPanel jcp = new JPanel(new BorderLayout());
        setContentPane(jcp);
        jcp.add(new DrawingComponent (x, y, n), BorderLayout.CENTER);
        setSize(800, 1000);
        setLocation(1100,100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}