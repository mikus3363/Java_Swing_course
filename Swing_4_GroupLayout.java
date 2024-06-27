package kursJava;

import javax.swing.*;
import java.awt.*;

public class Swing_4_GroupLayout extends JFrame {
    public Swing_4_GroupLayout()
    {
        this.setBounds(300,300,300,200);

        initComponents();

        this.setDefaultCloseOperation(3);
    }

    public void initComponents()
    {
        GroupLayout layout = new GroupLayout(getContentPane());
        this.getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        //ustawienie poziome
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(button1,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)//rozszerzanie w poziomie
                        .addGroup(
                                layout.createParallelGroup().addComponent(button2).addComponent(button4)
                        )
                        .addComponent(button3)
                        .addContainerGap(10,Short.MAX_VALUE)
                        .addComponent(anuluj)
                );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(//rozszerzanie w pionie
                                layout.createParallelGroup().addComponent(button1,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE).addComponent(button2).addComponent(button3)
                        )
                        .addComponent(button4)
                        .addContainerGap(10,Short.MAX_VALUE)
                        .addComponent(anuluj)
                );
        pack();
    }

    JButton button1 = new JButton("Button1");
    JButton button2 = new JButton("Button2");
    JButton button3 = new JButton("Button3");
    JButton button4 = new JButton("Button4");
    JButton anuluj = new JButton("Anuluj");

    public static void main(String[] args) {
        new Swing_4_GroupLayout().setVisible(true);
    }
}
