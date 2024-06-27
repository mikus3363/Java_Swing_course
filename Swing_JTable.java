package kursJava;

import javax.swing.*;
import java.awt.*;

public class Swing_JTable extends JFrame {
    public static void main(String[] args) {
        Swing_JTable frame = new Swing_JTable();

        String[] columns = {"Manufactures","Name","Year","Top speed"};

        String data[][] ={
                {"Ford","T","1920","40"},
                {"Opel","Astra","1970","200"}
        };

        JTable jt = new JTable(data,columns);

        jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane spane = new JScrollPane(jt);

        spane.setPreferredSize(new Dimension(300,100));

        frame.add(spane,BorderLayout.CENTER);
        frame.pack();

        jt.setValueAt("35",0,3);//zmiana wartosci
        System.out.println(jt.getValueAt(1,1));
        System.out.println("liczba kolumn: "+jt.getColumnCount());
        System.out.println("nazwa kolumny 0: "+jt.getColumnName(0));


        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
