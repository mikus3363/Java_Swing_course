package kursJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Swing_JComboBox_plus extends JFrame {
    public static void main(String[] args) {
        Swing_JComboBox_plus frame = new Swing_JComboBox_plus();

        String[] prog = {"Java","C++","PHP","JavaScript"};

        JComboBox<String> cb = new JComboBox<>(prog);

        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("selected: "+ prog[cb.getSelectedIndex()]);
            }
        });

        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int state = e.getStateChange();
                if(state==ItemEvent.SELECTED){
                    System.out.println(e.getItem()+ " selected");
                } else if (state==ItemEvent.DESELECTED) {
                    System.out.println(e.getItem()+ " deselected");
                }
            }
        });

        frame.add(cb);

        frame.setLayout(new FlowLayout());
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
