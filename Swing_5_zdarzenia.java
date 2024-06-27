package kursJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Swing_5_zdarzenia extends JFrame implements ActionListener{
    public Swing_5_zdarzenia()
    {
        super("Zdarzenia");
        this.setBounds(300,300,300,200);

        initComponents();

        //this.pack();

        this.setDefaultCloseOperation(3);
    }
    public void initComponents()
    {
        kolorczerwony = new JButton("Czerwony");
        kolorniebieski = new JButton("Niebieski");
        kolorzolty = new JButton("Zolty");
        kolorczerwony.addActionListener(new sluchaczKolorow(Color.RED));//wywolanie to co w sluchaczKolorow
        kolorniebieski.addActionListener(new sluchaczKolorow(Color.BLUE));

        kolorzolty.addActionListener(this);

        panel.add(kolorczerwony);
        panel.add(kolorniebieski);
        panel.add(kolorzolty);

        budujButton("Zielony",Color.green);

        this.getContentPane().add(panel);
    }
    public void budujButton(String nazwa, Color k){
        JButton przycisk = new JButton(nazwa);
        przycisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(k);
            }
        });
        panel.add(przycisk);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == kolorzolty){panel.setBackground(Color.yellow);}
    }

    private class sluchaczKolorow implements ActionListener
    {
        public sluchaczKolorow(Color k)
        {
            this.kolor = k;
        }
        public void actionPerformed(ActionEvent e)//po klikniecu jest tworzony obiekt ActionEvent
        {
            panel.setBackground(kolor);
        }
        Color kolor;
    }

    JPanel panel = new JPanel();
    JButton kolorczerwony;
    JButton kolorniebieski;
    JButton kolorzolty;

    public static void main(String[] args) {
        new Swing_5_zdarzenia().setVisible(true);
    }
}
