package kursJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Swing_00_zapisz_wczytaj extends JFrame{
    public Swing_00_zapisz_wczytaj()
    {
        initComponents();
    }
    public void initComponents()
    {
        this.setTitle("Wczytaj Zapisz");
        this.setBounds(300,300,300,200);

        panel1.add(obszarPrzewijania);
        panel2.add(zapisz);
        panel2.add(wczytaj);

        wczytaj.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser jFileChooser = new JFileChooser();
                int result = jFileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = jFileChooser.getSelectedFile();
                    try {
                        tekst.read( new FileReader( file.getAbsolutePath() ), null );
                    } catch (IOException e) {
                        System.out.println("Nie mogę otworzyć pliku: " + file.getAbsolutePath());
                        System.out.println("Problem: " + e);
                    }
                }

            }
        });
        zapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fc = new JFileChooser();
                if(fc.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                    File plik = fc.getSelectedFile();
                    try{
                        PrintWriter pw = new PrintWriter(plik);
                        Scanner skaner = new Scanner(tekst.getText());
                        while(skaner.hasNext()){
                            pw.println(skaner.nextLine()+"\n");
                        }
                        pw.close();

                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    JOptionPane.showMessageDialog(null,"Wybrany plik to "+plik);
                }
            }
        });

        this.getContentPane().add(panel1,BorderLayout.CENTER);
        this.getContentPane().add(panel2,BorderLayout.NORTH);

        this.setDefaultCloseOperation(3);
    }

    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JButton zapisz = new JButton("Zapisz");
    private JButton wczytaj = new JButton("Wczytaj");
    private JTextArea tekst = new JTextArea(7,20);
    private JScrollPane obszarPrzewijania = new JScrollPane(tekst);



    public static void main(String[] args) {
        new Swing_00_zapisz_wczytaj().setVisible(true);
    }
}
