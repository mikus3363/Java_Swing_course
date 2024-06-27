package kursJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class Swing_JColorChooser extends JFrame {
    public static void main(String[] args) {
        Swing_JColorChooser frame = new Swing_JColorChooser();

        Color color = JColorChooser.showDialog(frame,"Wybierz kolor",Color.BLUE);

        System.out.println("selected: "+color);

        JLabel label = new JLabel("Label");
        frame.add(label);
        label.setForeground(color);

        frame.setLayout(new FlowLayout());
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}
