package kursJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Swing_9_Menu extends JFrame {
    public Swing_9_Menu()
    {

        initComponents();

    }
    public void initComponents()
    {
        this.setTitle("Wlasne Menu");
        this.setBounds(300,300,300,200);

        panelMenu.setLayout(new GridLayout(3,1));//ustawienie w oknie wartosci elementow

        panelMenu.add(menu1);
        panelMenu.add(menu2);
        panelMenu.add(menu3);

        kontener.add(panelMenu);
        this.setDefaultCloseOperation(3);
    }

    private Container kontener = this.getContentPane();
    private JPanel panelMenu = new JPanel();
    private MenuButton menu1 = new MenuButton("1.Dodaj");
    private MenuButton menu2 = new MenuButton("2.Usun");
    private MenuButton menu3 = new MenuButton("3.Zmien");
    private int i = 0;


    private class MenuButton extends JButton implements FocusListener,ActionListener { //FocusListener to interfejs do dzialania kiedy skupiasz fokus na danym komponencie
        public MenuButton(String nazwa){
            super(nazwa);
            this.addFocusListener(this);
            this.addActionListener(this);
//            this.addKeyListener(new KeyListener() {
//                //naciskam->drukuje->opuszam
//                @Override
//                public void keyTyped(KeyEvent keyEvent) {//klawisz wypisany
//
//                }
//
//                @Override
//                public void keyPressed(KeyEvent keyEvent) {//klawisz nacisniety
//
//                }
//
//                @Override
//                public void keyReleased(KeyEvent keyEvent) {//klawisz opuszczony
//
//                }
//            });
            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    keyPressedHandler(e);
                }
            });
            this.setBackground(kDefault);
        }
        @Override
        public void focusGained(FocusEvent focusEvent) { //wywolana kiedy komponen dostaje fokus od klawisza
            this.setBackground(kFocusGained);
        }

        @Override
        public void focusLost(FocusEvent focusEvent) {//kiedy stracimy fokus wroc do pozycji startowej
            this.setBackground(kDefault);
        }

        private void keyPressedHandler(KeyEvent e){
            int dlMenu = panelMenu.getComponentCount();

            if(i==0) i=10*dlMenu;//zabezpieczenie przed i=-1 i wywaleniem bledu

            if(e.getKeyCode() == KeyEvent.VK_DOWN){//KeyEvent.przycisk na klawiaturze za pomoca tego ifa narzucamy dzialanie programu gdy wcisniemy przycisk
                panelMenu.getComponent(++i%dlMenu).requestFocus();//przechodzenie w dol po komponentach
            }
            if(e.getKeyCode() == KeyEvent.VK_UP){
                panelMenu.getComponent(--i%dlMenu).requestFocus();
            }
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
//                MenuButton tmp = (MenuButton) e.getSource();//rzutowanie na typ klasowy bo getSource zwraca typ obiektowy
//                tmp.doClick();//zasymulowanie przycisku myszką
                ((MenuButton) e.getSource()).doClick(); //najpierw pobieramy kto go wywolal pozniej rzutujemy i tą rzutowana wartosc wywolujemy metode doClick
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(this,((MenuButton)e.getSource()).getText());// zmienna ktora pokaze nam dialog , przekazana wiadomosc(do czego ma wycentrowac,co ma sie wyswietlic)
        }
        private Color kFocusGained = Color.RED;
        private Color kDefault = Color.BLUE;
    }

    public static void main(String[] args) {
        new Swing_9_Menu().setVisible(true);
    }
}
