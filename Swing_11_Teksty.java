package kursJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing_11_Teksty extends JFrame {
    public Swing_11_Teksty(){
        initComponents();
    }

    public void initComponents(){
        this.setTitle("Przeszukiwanie Tekstow");
        this.setBounds(300,300,400,200);

        panelSzukania.add(znajdz);
        panelSzukania.add(szukany);
        panelSzukania.add(etykieta1);
        panelSzukania.add(zamien);
        panelSzukania.add(etykieta2);
        panelSzukania.add(nowyTekst);

        //obszarTekst.selectAll();//zaznacza caly tekst
        //obszarTekst.select(0,2);//zaznacza dany obszar
        //obszarTekst.replaceSelection("lala");//zamiana zaznaczonego obszaru
        //obszarTekst.replaceRange("lala",0,2);//zaznacza podany tekst i zamienia
        //obszarTekst.insert("jakistam",0);//dodaje tekst w danym miejscu
        //obszarTekst.append("do konca");//dolacza do konca tekstu
        //obszarTekst.select(obszarTekst.getText().indexOf("test"),obszarTekst.getText().indexOf("test")+"test".length());//wyszukuje dany fragment i mozna go zaznaczyc, karetka przeskakuje do tego miejsca

        znajdz.addActionListener(new znajdowanieHandle());
        zamien.addActionListener(new zamienianieHandle());
        this.getContentPane().add(obszarPrzewijania, BorderLayout.NORTH);
        this.getContentPane().add(panelSzukania, BorderLayout.CENTER);


        this.setDefaultCloseOperation(3);
    }
    private JTextArea obszarTekst = new JTextArea("To jest testowy tekst o testowym charakterze",7,10);
    private JScrollPane obszarPrzewijania = new JScrollPane(obszarTekst);
    private JPanel panelSzukania = new JPanel();
    private JButton znajdz = new JButton("Znajdz");
    private JTextField szukany = new JTextField(4);
    private JLabel etykieta1 = new JLabel("i");
    private JButton zamien = new JButton("Zamien");
    private JLabel etykieta2 = new JLabel("na");
    private JTextField nowyTekst = new JTextField(4);

    private class znajdowanieHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            poczatekSzuka = obszarTekst.getText().indexOf(szukany.getText(),poczatekSzuka+szukany.getText().length());
            if(poczatekSzuka==-1){
                poczatekSzuka = obszarTekst.getText().indexOf(szukany.getText());
            }

            if(poczatekSzuka>=0 && szukany.getText().length()>0){

                obszarTekst.requestFocus();
                obszarTekst.select(poczatekSzuka,poczatekSzuka+szukany.getText().length());
            }
        }
        private int poczatekSzuka = 0;
    }
    private class zamienianieHandle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(obszarTekst.getSelectionStart()!=obszarTekst.getSelectionEnd()){
                zamienTekst();
            }
            else{
                znajdz.doClick(0);
                if(obszarTekst.getSelectionStart()!=obszarTekst.getSelectionEnd()) zamienTekst();
            }

        }
        private void zamienTekst(){
            obszarTekst.requestFocus();
            int opcja = JOptionPane.showConfirmDialog(rootPane,"Czy chcesz zamienic\""+szukany.getText()+"\" na "+nowyTekst.getText()+"\"","Uwaga nastapi zmiana!",JOptionPane.YES_NO_OPTION);
            if(opcja == 0) obszarTekst.replaceRange(nowyTekst.getText(),obszarTekst.getSelectionStart(),obszarTekst.getSelectionEnd());
        }
    }

    public static void main(String[] args) {
        new Swing_11_Teksty().setVisible(true);
    }
}
