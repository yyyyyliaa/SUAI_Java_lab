package test.Practice.Workout;

import javax.swing.*;
import java.awt.*;

class DrawingComponent extends JPanel {
    int xg[];
    int yg[];
    int ng;

    public DrawingComponent(int[] x, int[]y, int n){
        xg = x;
        yg = y;
        ng = n;
    }
    @Override
    protected void paintComponent(Graphics gh) {
        Graphics2D drp = (Graphics2D)gh;
        drp.drawLine(20, 340, 20, 20);
        drp.drawLine(20, 340, 460, 340);
        drp.drawPolyline(xg, yg, ng);
    }
}

