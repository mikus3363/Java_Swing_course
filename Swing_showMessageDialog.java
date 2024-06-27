package kursJava;

import javax.swing.*;

public class Swing_showMessageDialog extends JFrame {
    public static void main(String[] args) {
        Swing_showMessageDialog frame = new Swing_showMessageDialog();

        //JOptionPane.showMessageDialog(frame,"Siema Eniu","Title",JOptionPane.PLAIN_MESSAGE);

        ImageIcon icon = new ImageIcon("lufa.png");

        JOptionPane.showMessageDialog(null,"<html><u>Siema Eniu<html>","Title",JOptionPane.ERROR_MESSAGE,icon);


        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        //frame.setVisible(true);
    }
}
