package kursJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Swing_7_Radio extends JFrame{
    public Swing_7_Radio()
    {

        initComponents();

    }
    public void initComponents()
    {
        this.setTitle("Grupy przelacznikow Radio");
        this.setBounds(300,300,300,200);

        panel2.add(etykieta);

//        JRadioButton malyprzelacznik = new JRadioButton("maly",false);//podajac true od razu zaznacza sie
//        JRadioButton sredniprzelacznik = new JRadioButton("sredni",false);
//
//        malyprzelacznik.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                etykieta.setFont(new Font("Monospaced",Font.BOLD,25));//zmiana czcionki nazwa,styl,wielkosc
//            }
//        });
//
//        grupawielkosci.add(malyprzelacznik);
//        grupawielkosci.add(sredniprzelacznik);
//
//        panel1.add(malyprzelacznik);
//        panel1.add(sredniprzelacznik);

        zbudujPrzelacznikRozmiar("Maly",15);
        zbudujPrzelacznikRozmiar("Sredni",25);
        zbudujPrzelacznikRozmiar("Duzy",35);

        zbudujPrzelacznikKolor("Zielony",Color.green);
        zbudujPrzelacznikKolor("Czerwony",Color.red);
        zbudujPrzelacznikKolor("Niebieski",Color.blue);

        this.getContentPane().add(panel1,BorderLayout.NORTH);
        this.getContentPane().add(panel2,BorderLayout.SOUTH);
        this.getContentPane().add(panel3,BorderLayout.CENTER);


        this.setDefaultCloseOperation(3);
    }

    public void zbudujPrzelacznikRozmiar(String nazwa,final int rozmiar){
        JRadioButton przelacznik = new JRadioButton(nazwa);
        przelacznik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etykieta.setFont(new Font("Monospaced",Font.PLAIN,rozmiar));
            }
        });
        grupawielkosci.add(przelacznik);
        panel1.add(przelacznik);
    }
    public void zbudujPrzelacznikKolor(String nazwa,final Color k){
        JRadioButton przelacznik = new JRadioButton(nazwa);
        przelacznik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etykieta.setForeground(k);
            }
        });

        grupakolorow.add(przelacznik);
        panel3.add(przelacznik);
    }

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel etykieta = new JLabel("cos");

    ButtonGroup grupawielkosci = new ButtonGroup();//dodanie grupy sprawia ze moze byc jeden radiobutton zaznaczony
    ButtonGroup grupakolorow = new ButtonGroup();//dodanie grupy kolorow


    public static void main(String[] args) {
        new Swing_7_Radio().setVisible(true);
    }
}
