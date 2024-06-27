package kursJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing_12_listkomb extends JFrame {
    public Swing_12_listkomb(){
        initComponents();
    }
    public void initComponents(){
        this.setTitle("Listy kombinowane");
        this.setBounds(300,300,300,200);

        panel.add(kombinacja);

        kombinacja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ColorHander hander = (ColorHander)((JComboBox)actionEvent.getSource()).getSelectedItem();
                ((JComboBox)actionEvent.getSource()).setBackground(hander.getKolor());
            }
        });

        kombinacja.addItem(new ColorHander(Color.BLACK,"Czarny"));
        kombinacja.addItem(new ColorHander(Color.GREEN,"Zielony"));
        kombinacja.addItem(new ColorHander(Color.RED,"Czerwony"));
        kombinacja.addItem(new ColorHander(Color.YELLOW,"Żólty"));

        this.getContentPane().add(panel);

        this.setDefaultCloseOperation(3);
    }

    private class ColorHander
    {
        public ColorHander(Color kolor,String colorName){
            this.kolor = kolor;
            this.colorName = colorName;
        }
        @Override
        public String toString(){
            return this.colorName;
        }

        public Color getKolor() {
            return kolor;
        }

        private Color kolor;
        private String colorName;
    }


    private JPanel panel = new JPanel();
    private JComboBox kombinacja = new JComboBox();

    public static void main(String[] args) {
        new Swing_12_listkomb().setVisible(true);
    }
}
