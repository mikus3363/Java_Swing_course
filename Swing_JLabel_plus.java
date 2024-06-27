package kursJava;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Swing_JLabel_plus extends JFrame {
    public static void main(String[] args) {
        Swing_JLabel_plus frame = new Swing_JLabel_plus();


        JLabel label1 = new JLabel("Text");
        label1.setText("<html><u>Nowy tekst<html>");
        label1.setBounds(10,10,80,50);
        label1.setForeground(Color.BLUE);

        label1.setOpaque(true);
        label1.setBackground(Color.WHITE);
        label1.setHorizontalAlignment(JLabel.CENTER);
        Border border = BorderFactory.createLineBorder(Color.RED,3);
        label1.setBorder(border);

        frame.add(label1);

        frame.setLayout(null);
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
