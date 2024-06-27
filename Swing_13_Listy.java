package kursJava;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Swing_13_Listy extends JFrame {
    public Swing_13_Listy(){
        initComponents();
    }
    public void initComponents(){
        this.setTitle("Lista");
        this.setBounds(300,300,300,200);
        komunikat.setText("lala");

        panelLista.add(scrollListy);
        panelKomunikat.add(komunikat);
        listaPrzedmiotow.setVisibleRowCount(4); //ilosc pol ktore ma pokazywac
        //listaPrzedmiotow.setPrototypeCellValue("lala"); //wielkosc pol taka sama jak to co wpiszemy
        //listaPrzedmiotow.setFixedCellHeight(40); //ustawiamy wielkosc elementow listy
        //listaPrzedmiotow.setFixedCellWidth(200); //ustawiamy szerokosc elementow listy
        //listaPrzedmiotow.setBackground(Color.BLUE); //ustawia kolory elementow(wszystkie)
        //listaPrzedmiotow.setSelectionBackground(Color.RED); //ustawia kolor elementu ktory zaznaczymy
        //listaPrzedmiotow.setSelectionForeground(Color.GREEN); //po najechaniu zmiana koloru czcionki

        //listaPrzedmiotow.setLayoutOrientation(JList.VERTICAL_WRAP); //ustawianie kolumnowo elementow
        //listaPrzedmiotow.setLayoutOrientation(JList.HORIZONTAL_WRAP); //ustawianie elementow tak jak czytamy

        listaPrzedmiotow.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); //styl zaznaczenia

        listaPrzedmiotow.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting())
                    System.out.println("Trzymam button myszy");
                else{
                    System.out.println("Póscilem button myszy");
                }
                if(!e.getValueIsAdjusting()){
                    //String zawartosc = (String)((JList)e.getSource()).getSelectedValue();
                    Object[] wartosciWLiscie = ((JList)e.getSource()).getSelectedValues();

                    String przedmioty = "";

                    for(int i=0;i<wartosciWLiscie.length;i++){
                        przedmioty +=(String)wartosciWLiscie[i]+" ";
                    }
                    System.out.println(przedmioty);

                    //System.out.println(zawartosc);

                    komunikat.setText("Nie lubie: ");
                }
            }
        });

        final DefaultListModel modelListy = new DefaultListModel();

        String[] tekst = new String[]{"Nowak","Cosik","Kosztowniak","Molesa"};

        JList lista2 = new JList(modelListy);

        modelListy.addElement("Zbys");

        lista2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                //modelListy.removeAllElements();
                for(int i=0;i<tekst.length;i++){
                    modelListy.addElement(tekst[i]);
                }
            }
        });

        //modelListy.remove(3);



        this.getContentPane().add(panelKomunikat, BorderLayout.SOUTH);
        this.getContentPane().add(panelLista, BorderLayout.CENTER);
        this.getContentPane().add(lista2,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(3);
    }
    private JPanel panelLista = new JPanel();
    private JList listaPrzedmiotow = new JList(new String[]{"Matemtatyka","Fizyka","Informatyka","Wos","Angielski","Historia","Plastyka","Chemia","Muzyka","Niemiecki"});
    private JScrollPane scrollListy = new JScrollPane(listaPrzedmiotow);
    private JPanel panelKomunikat = new JPanel();
    private JLabel komunikat = new JLabel();

    public static void main(String[] args) {
        new Swing_13_Listy().setVisible(true);
    }
}
