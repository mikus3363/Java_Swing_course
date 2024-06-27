package kursJava;

import javax.swing.*;
import java.awt.*;

public class Swing_2_przyciski extends JFrame {

    public Swing_2_przyciski()
    {
        super("Uklad graficzny (Layout)");
        this.setBounds(300,320,300,200);

        initComponents();

        //this.pack();

        this.setDefaultCloseOperation(3);
    }
    public void initComponents()
    {
        przyciskcentrum = new JButton("Heja!");
        przyciskgora = new JButton("Jestem na gorze");
        przyciskdol = new JButton("Jestem na dole");
        przyciskprawa = new JButton("Jestem na prawo");
        przycisklewa = new JButton("Jestem na lewo");
        anuluj = new JButton("Auluj");

        Container kontener = this.getContentPane();

//        kontener.add(przyciskcentrum,BorderLayout.CENTER);
//        kontener.add(przyciskgora,BorderLayout.PAGE_START);
//        kontener.add(przyciskdol,BorderLayout.PAGE_END);
//        kontener.add(przyciskprawa,BorderLayout.LINE_END);
//        kontener.add(przycisklewa,BorderLayout.LINE_START);

        anuluj.setLocation(100,100);
        anuluj.setSize(150,20);
        kontener.setLayout(null);
        kontener.add(anuluj);
    }

    JButton przyciskcentrum;
    JButton przyciskgora;
    JButton przyciskdol;
    JButton przyciskprawa;
    JButton przycisklewa;
    JButton anuluj;

    public static void main(String[] args) {
        new Swing_2_przyciski().setVisible(true);
    }
}
