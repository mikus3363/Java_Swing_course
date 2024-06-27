package kursJava;

import javax.swing.*;

public class Swing_showConfirmDialog extends JFrame{
    public static void main(String[] args) {
        Swing_showConfirmDialog frame = new Swing_showConfirmDialog();

        int result = JOptionPane.showConfirmDialog(
                null,"Zapisać dane?","Dane zmodyfikowane",JOptionPane.YES_NO_CANCEL_OPTION
        );

        String str = "";
        switch (result){
            case JOptionPane.YES_OPTION:
                str = "yes";
                break;
            case JOptionPane.NO_OPTION:
                str = "no";
                break;
            case JOptionPane.CANCEL_OPTION:
                str = "cancel";
                break;
        }
        System.out.println("Opcja: "+str);



        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        //frame.setVisible(true);
    }
}
