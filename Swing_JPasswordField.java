package kursJava;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing_JPasswordField extends JFrame{
    public static void main(String[] args) {
        Swing_JPasswordField frame = new Swing_JPasswordField();


        JPasswordField jp = new JPasswordField(10);

        jp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("password: "+ new String(jp.getPassword()));
                if(new String(jp.getPassword()).equals("maslo")){
                    System.out.println("niezle haslo brachu");
                }
            }
        });


        frame.add(jp);

        frame.setLayout(new FlowLayout());
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
