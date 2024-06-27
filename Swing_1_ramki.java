package kursJava;

import javax.swing.JFrame;
import java.awt.*;

public class Swing_1_ramki extends JFrame{

    public Swing_1_ramki(){
        /*
        JFrame frame = new JFrame("Tytul ramki");
        //frame.setTitle("Tytul ramki");// nadanie tytulu ramki

        frame.setSize(300,300);//ustawianie wielkosci ramki
        //frame.setSize(new Dimension(300,300));//drugie ustawienie wielkosci ramki

        frame.setLocation(100,100);//nadanie lokalizacji ramki
        //frame.setLocation(new Point(100,100));//drugie nadanie lokalizacji ramki

        //frame.setBounds(100,100,300,300);//ustawianie od razu najpierw lokalizacja pozniej wielkosc ramki

        //frame.setResizable(false);//nie mozna powiekszac ramki

        //frame.setIconImage(Toolkit.getDefaultToolkit().getImage("nazwa obrazki JPG"));//zmiana ikony ramki

        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(3);// 3 czyta że jest to zakonczenie programu
        frame.setVisible(true);

         */

        super("Tytul ramki");
        int szer = Toolkit.getDefaultToolkit().getScreenSize().width;
        int wys = Toolkit.getDefaultToolkit().getScreenSize().height;

        this.setSize(szer/2,wys/2);//ustawienie wielkosci okienka

        int szerRamki = this.getSize().width;
        int wysRamki = this.getSize().height;

        this.setLocation((szer-szerRamki)/2,(wys-wysRamki)/2);//wycentrowanie okienka na sam srodek ekranu(uniwersalnie)

        this.setDefaultCloseOperation(3);
        //this.pack();//po dodaniu komponentow są szybsze kalkulacje
    }
    public static void main(String[] args) {
        new Swing_1_ramki().setVisible(true);
    }
}
