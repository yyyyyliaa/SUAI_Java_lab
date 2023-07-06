package test.Practice.Workout;

import javax.swing.*;

public class ResButton extends JButton {
    public ResButton(String text){
        super(text);
    }

    public void addActionListener(){
        super.addActionListener(e -> {
//              new Chart().setVisible(true);
        });;
    }
}
