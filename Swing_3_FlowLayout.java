package kursJava;

import javax.swing.*;
import java.awt.*;

public class Swing_3_FlowLayout extends JFrame {

    public Swing_3_FlowLayout()
    {
        this.setBounds(300,300,300,200);

        initComponents();

        this.setDefaultCloseOperation(3);
    }

    public void initComponents()
    {

        button1.setPreferredSize(new Dimension(200,100));//przy takiej zmianie mozna zmieniac tylko wysokosc
        button2.setPreferredSize(button2.getPreferredSize());

        panel1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);//zmiana orientacji komponentow

        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);

        this.getContentPane().add(panel1, BorderLayout.CENTER);



    }

    JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));//panele sluza nam do grupowania elementow
    JButton button1 = new JButton("Button1");
    JButton button2 = new JButton("Button2");
    JButton button3 = new JButton("Button3");
    JButton button4 = new JButton("Button4");

    public static void main(String[] args) {
        new Swing_3_FlowLayout().setVisible(true);
    }
}
