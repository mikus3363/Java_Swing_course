package kursJava;

import javax.swing.*;

public class Swing_showInputDialog extends JFrame{
    public static void main(String[] args) {
        Swing_showInputDialog frame = new Swing_showInputDialog();

//        String result = JOptionPane.showInputDialog(
//                null,
//                "Wpisz swoje imie: "
//        );
//        System.out.println("Twoje imie: "+result);

        String[] cars = {"Ford","Opel","Mazda"};

        String result2 = (String) JOptionPane.showInputDialog(
                null,
                null,
                "Wybierz samochód",
                JOptionPane.QUESTION_MESSAGE,
                null,cars,
                cars[0]
        );
        System.out.println("Wybrane auto: "+result2);




        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        //frame.setVisible(true);
    }
}
