package kursJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing_10_Jtext extends JFrame implements ActionListener {
    public Swing_10_Jtext(){

        initComponents();
    }

    public void initComponents(){
        setTitle("Przeliczanie stopni");
        this.setSize(400,200);
        this.setLayout(null);


        celcjusz.setBounds(20,20,150,20);
        fahrenheit.setBounds(20,70,150,20);
        tcelcjusz.setBounds(170,20,100,20);
        tfahrenheit.setBounds(170,70,100,20);

        przycisk.setBounds(70,120,150,20);
        this.add(przycisk);

        this.add(celcjusz);
        this.add(fahrenheit);
        this.add(tcelcjusz);
        this.add(tfahrenheit);
        przycisk.addActionListener(this);

        setDefaultCloseOperation(3);
    }
    private JButton przycisk = new JButton("Konwertuj");
    private JLabel celcjusz = new JLabel("Stopnie Celcjusza: ");
    private JLabel fahrenheit = new JLabel("Stopnie Fahrenheita: ");
    private JTextField tcelcjusz = new JTextField("");
    private JTextField tfahrenheit = new JTextField("");
    private double tempCelc;
    private double tempFahr;


    public static void main(String[] args) {
        new Swing_10_Jtext().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        tempCelc = Double.parseDouble(tcelcjusz.getText());
        tempFahr = 32.0 + ((9.0/5.0)*tempCelc);
        tfahrenheit.setText(String.valueOf(tempFahr));
    }
}
