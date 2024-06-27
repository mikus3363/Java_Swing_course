package kursJava;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

public class Swing_WindowListener extends JFrame implements WindowListener {
    public static void main(String[] args) {
        Swing_WindowListener frame = new Swing_WindowListener();

        frame.addWindowListener(frame);

        frame.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent windowEvent) {
                System.out.println("Window gained focus");
            }

            @Override
            public void windowLostFocus(WindowEvent windowEvent) {
                System.out.println("Window lost focus");
            }
        });

        frame.setSize(300,200);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {
        System.out.println("Window open");
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        System.out.println("Window close");
        this.dispose();//zwolnienie zasobów okna
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {
        System.out.println("Okno zamknięte");
    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {
        System.out.println("Okno zminimalizowane");
    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {
        System.out.println("Okno pokazane");
    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {
        System.out.println("Okno aktywowane");
    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {
        System.out.println("Okno deaktywowane");
    }
}
