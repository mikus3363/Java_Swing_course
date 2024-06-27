package kursJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Swing_JPopupMenu extends JFrame{
    public static void main(String[] args) {
        Swing_JPopupMenu frame = new Swing_JPopupMenu();

        JPopupMenu popup = new JPopupMenu("Edit");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");

        popup.add(cut);
        popup.add(copy);
        popup.add(paste);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JMenuItem item = (JMenuItem) actionEvent.getSource();
                System.out.println("clocked: "+item.getText());
            }
        };

        cut.addActionListener(listener);
        copy.addActionListener(listener);
        paste.addActionListener(listener);

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton()==MouseEvent.BUTTON3){
                    popup.show(frame,e.getX(),e.getY());
                }
            }
        });


        frame.setLayout(new FlowLayout());
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}
