package test.Practice.Workout;


import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;

public class Workout extends JFrame {
    public HashSet<String> days = new HashSet<>();
    public HashMap<String, TrainingDay> trDays = new HashMap<>();
    public Workout() {
        super("Workout");
        setSize(1500, 1000);
        setLocation(100, 100);
        setDefaultCloseOperation( EXIT_ON_CLOSE );


        Container c = getContentPane();
        c.setLayout( new GridLayout(3, 1) );


        DayButton day = new DayButton("Day");
        day.addActionListener(days);

//        JButton day = new JButton("Day");
//        day.setPreferredSize(new Dimension(300, 20));
//        day.addActionListener(e -> {
//            Object[] optionsToChoose = days.toArray();
//            String getDay = (String) JOptionPane.showInputDialog(
//                    null,
//                    "Chose the day",
//                    "Day",
//                    JOptionPane.QUESTION_MESSAGE,
//                    null,
//                    optionsToChoose,
//                    " ");
//            if(!(getDay ==null)){
//                if(!getDay.equals(" ")){
//                    day.setLabel(getDay);
//                } else {
//                    day.setLabel("Day");
//                }
//            }
//        });

        AddButton add = new AddButton("Add");
        add.addActionListener(days, trDays,this);


//        JButton add = new JButton("Add");
//        add.setPreferredSize(new Dimension(300, 20));
//        add.addActionListener(e -> {
//            String data;
//            boolean flag = true;
//            data = JOptionPane.showInputDialog ("Enter the date in the format: dd/mm");
//
//            if(data.charAt(2) != '/'){
//                JOptionPane.showMessageDialog(Workout.this,"Wrong data");
//            } else {
//                String[] tokens = data.split("/");
//                int d = Integer.parseInt(tokens[0]);
//                int m = Integer.parseInt(tokens[1]);
//                if(d>0 && d<32 && m>0 && m<13){
//                    days.add(data);
//                    trDays.put(data, new TrainingDay(d, m));
//                } else JOptionPane.showMessageDialog(Workout.this,"Wrong data");
//            }
//        });

        ResButton res = new ResButton("Results");


//        JButton res = new JButton("Results");
//        res.setPreferredSize(new Dimension(300, 20));
//        res.addActionListener(e -> {
////              new Chart().setVisible(true);
//        });

        c.add(day);
        c.add(add);
        c.add(res);
    }

    public static void main(String[] args) {
        new Workout().setVisible(true);
    }
}
