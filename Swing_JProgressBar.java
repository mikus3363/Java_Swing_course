package kursJava;

import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class Swing_JProgressBar extends JFrame {
    public static void main(String[] args) {
        Swing_JProgressBar frame = new Swing_JProgressBar();

        JProgressBar progressBar = new JProgressBar();
        progressBar.setMinimum(0);
        progressBar.setMaximum(200);
        progressBar.setBackground(Color.BLACK);
        progressBar.setForeground(Color.GREEN);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0;i<=200;i+=1){
                        Thread.sleep(20);
                        progressBar.setValue(i);
                        if(progressBar.getValue()==200){
                            i=-1;
                            //progressBar.setValue(i);
                        }
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        frame.add(progressBar);
        t.start();

        frame.setLayout(new FlowLayout());
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
