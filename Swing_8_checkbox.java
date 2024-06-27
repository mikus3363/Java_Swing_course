package kursJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing_8_checkbox extends JFrame {
    public Swing_8_checkbox()
    {

        initComponents();

    }
    public void initComponents()
    {
        this.setTitle("Pole Wyboru");
        this.setBounds(300,300,300,200);

        etykieta.setFont(new Font("Monospaced",Font.PLAIN,25));

        ActionListener sluchacz = new CheckBoxHander();

        pogrubiony.addActionListener(sluchacz);
        pochylony.addActionListener(sluchacz);
        panel1.add(pogrubiony);
        panel1.add(pochylony);

        panel2.add(etykieta);

        this.getContentPane().add(panel1,BorderLayout.NORTH);
        this.getContentPane().add(panel2,BorderLayout.CENTER);

        this.setDefaultCloseOperation(3);
    }

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JLabel etykieta = new JLabel("Jestem tutaj");
    JCheckBox pogrubiony = new JCheckBox("Bogrubiony");
    JCheckBox pochylony = new JCheckBox("Pochylony");

    public class CheckBoxHander implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int style = Font.PLAIN;
            if(pogrubiony.isSelected()){
                style += Font.BOLD;
            }
            if(pochylony.isSelected()){
                style += Font.ITALIC;
            }
            etykieta.setFont(new Font(etykieta.getFont().getFamily(),style,etykieta.getFont().getSize()));
        }
    }

    public static void main(String[] args) {
        new Swing_8_checkbox().setVisible(true);
    }
}
