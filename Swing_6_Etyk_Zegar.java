package kursJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Swing_6_Etyk_Zegar extends JFrame {
    public Swing_6_Etyk_Zegar()
    {
        super("Zegarek");
        this.setBounds(300,300,300,200);

        initComponents();

        //this.pack();

        this.setDefaultCloseOperation(3);
    }
    public void initComponents()
    {
        panel.add(etykieta);
        panel.add(czas);

        //czas.setText("11:27:10");

        ActionListener stoper = new Zegar();

        Timer zegar = new Timer(1000,stoper);

        zegar.start();

        this.getContentPane().add(panel);

        pack();
    }
    JPanel panel = new JPanel();
    JLabel etykieta = new JLabel("Zegar: ");
    JLabel czas = new JLabel(pobeirzCzas());

    private class Zegar implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            czas.setText(pobeirzCzas());
        }

    }
    public String pobeirzCzas(){
        GregorianCalendar kalendarzyk = new GregorianCalendar();

        String godzina = ""+kalendarzyk.get(Calendar.HOUR_OF_DAY);
        String minuta = ""+kalendarzyk.get(Calendar.MINUTE);
        String sekunda = ""+kalendarzyk.get(Calendar.SECOND);

        if (Integer.parseInt(godzina)<10){
            godzina = "0"+godzina;
        }
        if (Integer.parseInt(minuta)<10){
            minuta = "0"+minuta;
        }
        if (Integer.parseInt(sekunda)<10){
            sekunda = "0"+sekunda;
        }

        return godzina + " : " + minuta + " : " + sekunda;
    }

    public static void main(String[] args) {
        new Swing_6_Etyk_Zegar().setVisible(true);
    }
}
