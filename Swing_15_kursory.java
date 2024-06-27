package kursJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Swing_15_kursory extends JFrame {
    public Swing_15_kursory(){
        initComponent();
    }

    public void initComponent()
    {
        this.setTitle("Menu Kontekstowe");
        this.setBounds(300,300,300,200);


        this.setDefaultCloseOperation(3);
    }




    public static void main(String[] args) {
        new kursJava.Swing_15_kursory().setVisible(true);
    }

}