package kursJava;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Arrays;

public class Swing_JScrollBar extends JFrame {
    public static void main(String[] args) {
        Swing_JScrollBar frame = new Swing_JScrollBar();

        JScrollBar scrollBar = new JScrollBar(Adjustable.HORIZONTAL);
        scrollBar.setValue(20);
        scrollBar.setMinimum(0);
        scrollBar.setMaximum(100);
        //scrollBar.setPreferredSize(new Dimension(35,170));
        scrollBar.setPreferredSize(new Dimension(180,30));


        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if(e.getValueIsAdjusting()) return;
                System.out.println("scroll value: "+e.getValue());
            }
        });

        frame.add(scrollBar);

        frame.setLayout(new FlowLayout());
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}
