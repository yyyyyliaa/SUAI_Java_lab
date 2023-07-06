package test.Practice.Workout;

import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;

public class AddButton extends JButton {

    public AddButton(String text){
        super(text);
    }

    public void addActionListener(HashSet<String> days, HashMap<String, TrainingDay> trDays, Workout w){
        super.addActionListener(e -> {
            String data;
            data = JOptionPane.showInputDialog ("Enter the date in the format: dd/mm");

            if(data.charAt(2) != '/'){
                JOptionPane.showMessageDialog(w,"Wrong data");
            } else {
                String[] tokens = data.split("/");
                int d = Integer.parseInt(tokens[0]);
                int m = Integer.parseInt(tokens[1]);
                if(d>0 && d<32 && m>0 && m<13){
                    days.add(data);
                    trDays.put(data, new TrainingDay(d, m));
                } else JOptionPane.showMessageDialog(w,"Wrong data");
            }
        });
    }
}
