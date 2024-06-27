package kursJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Swing_14_mycha extends JFrame {
    public Swing_14_mycha(){
        initComponent();
    }

    public void initComponent()
    {
        this.setTitle("Menu Kontekstowe");
        this.setBounds(300,300,300,200);

        final JPopupMenu menuKontekst = new JPopupMenu();

        menuKontekst.add(new JMenuItem("Kopiuj"));
        menuKontekst.add(new JMenuItem("Wklej"));
        menuKontekst.add(new JMenuItem(new AbstractAction("Zamknij") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);//wylacznienie aplikacji
            }
        }));



        this.getContentPane().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {//klikniecie
                System.out.println("Click");
            }

            @Override
            public void mousePressed(MouseEvent e) {//przytrzymanie/wcisniecie
                System.out.println("pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {//zwalnianie/odklikciecie
                System.out.println("released");

                if(e.getClickCount()==3 && e.getButton()==MouseEvent.BUTTON1 && e.isShiftDown()){//Button1 = lewy;1,Button2 = srodkowy;2,Button3 = prawy;3,Nobutton = wywolanie programistycznie;0
                    JOptionPane.showMessageDialog(rootPane,"Pojebalo cie?");
                }
//                if(e.getButton()==MouseEvent.BUTTON3){
//                    menuKontekst.show(e.getComponent(),e.getX(),e.getY());
//                }
                if(e.isPopupTrigger()){
                    menuKontekst.show(e.getComponent(),e.getX(),e.getY());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {//chodzenie na okienko kursorem
                System.out.println("wszedlem sobie");
            }

            @Override
            public void mouseExited(MouseEvent e) {//wychodzenie z okienka kursorem
                System.out.println("odszedlem");
            }
        });

        this.getContentPane().add(testowiec, BorderLayout.SOUTH);//to jest nowy komponen i na nim teraz nie dziala menu kontekstowe
        this.setDefaultCloseOperation(3);
    }

    private JButton testowiec = new JButton("test");

    public static void main(String[] args) {
        new Swing_14_mycha().setVisible(true);
    }

}
