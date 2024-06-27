package kursJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class Swing_CheckBox_plus extends JFrame {

    public static void main(String[] args) {
        Swing_CheckBox_plus frame = new Swing_CheckBox_plus();

        JCheckBox check1 = new JCheckBox("Opcja 1");
        check1.setSelected(true);

        check1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                switch (itemEvent.getStateChange()){
                    case ItemEvent.SELECTED :
                        System.out.println("check1 selected");
                        break;
                    case ItemEvent.DESELECTED:
                        System.out.println("check1 deselected");
                        break;
                }
            }
        });
        check1.setBounds(10,10,100,50);
        frame.add(check1);



        MyIcon normal = new MyIcon(Color.black,"Normal");
        MyIcon rollover = new MyIcon(Color.red,"Rollover");
        MyIcon selected = new MyIcon(Color.green,"Selected");

        JCheckBox check2 = new JCheckBox(normal);
        check2.setRolloverIcon(rollover);
        check2.setSelectedIcon(selected);

        check2.setBounds(10,80,100,50);
        frame.add(check2);



        frame.setLayout(null);
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class MyIcon implements Icon{
    Color color;
    String text;

    public MyIcon(Color color, String text) {
        this.color = color;
        this.text = text;
    }

    @Override
    public void paintIcon(Component component, Graphics graphics, int x, int y) {
        graphics.setColor(color);
        graphics.drawString(text,10,10);
    }

    @Override
    public int getIconWidth() {
        return 32;
    }

    @Override
    public int getIconHeight() {
        return 32;
    }
}