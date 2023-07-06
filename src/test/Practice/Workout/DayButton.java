package test.Practice.Workout;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;

public class DayButton extends JButton {
    public DayButton(String text) {
        super(text);
    }

    public void addActionListener(HashSet<String> days) {
        super.addActionListener(e -> {
            Object[] optionsToChoose = days.toArray();
            String getDay = (String) JOptionPane.showInputDialog(
                    null,
                    "Chose the day",
                    "Day",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optionsToChoose,
                    " ");
            if(!(getDay ==null)){
                if(!getDay.equals(" ")){
                    this.setLabel(getDay);
                } else {
                    this.setLabel("Day");
                }
            }
        });
    }
}


