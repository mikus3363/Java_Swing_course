package kursJava;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Arrays;

public class Swing_JList_plus extends JFrame {
    public static void main(String[] args) {
        Swing_JList_plus frame = new Swing_JList_plus();

        DefaultListModel<String> df = new DefaultListModel<>();
        df.addElement("Java");
        df.addElement("PHP");
        df.addElement("Python");
        df.addElement("C++");
        df.addElement("JS");

        JList<String> lista = new JList<>(df);

        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()) return;
                int indices[] = lista.getSelectedIndices();
                Arrays.stream(indices).forEach(i -> System.out.println(lista.getModel().getElementAt(i)));
            }
        });

        frame.add(lista);

        frame.setLayout(new FlowLayout());
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
