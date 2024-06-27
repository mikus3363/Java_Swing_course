package kursJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Swing_DoubleBufferingExample extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    public Swing_DoubleBufferingExample() {
        setTitle("Double Buffering Example");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DoubleBufferingPanel panel = new DoubleBufferingPanel();
        add(panel);

        // Rozpocznij wątek obsługujący ruch
//        Thread moveThread = new Thread(panel.getMoveRunnable());
//        moveThread.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Swing_DoubleBufferingExample().setVisible(true));
    }
}

class DoubleBufferingPanel extends JPanel {
    private int x = 50;
    private int y = 50;
    private Color squareColor = Color.BLUE;

    public DoubleBufferingPanel() {
        // Utwórz timery
        Timer moveTimer = new Timer(10, e -> {
            moveSquare();
            repaint();
        });
        moveTimer.start();

        Timer colorTimer = new Timer(1000, e -> {
            changeSquareColor();
            repaint();
        });
        colorTimer.start();
    }

    public Runnable getMoveRunnable() {
        return new MoveRunnable();
    }

    private void moveSquare() {
        // Prosta logika przesuwania kwadratu
        x += 2;
        if (x > getWidth()) {
            x = -50;
        }
    }

    private void changeSquareColor() {
        // Zmiana koloru kwadratu co sekundę
        squareColor = new Color(
                (int) (Math.random() * 256),
                (int) (Math.random() * 256),
                (int) (Math.random() * 256)
        );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Utwórz bufor obrazu
        BufferedImage buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2dBuffer = buffer.createGraphics();

        // Rysuj na buforze
        g2dBuffer.setColor(Color.WHITE);
        g2dBuffer.fillRect(0, 0, getWidth(), getHeight());

        g2dBuffer.setColor(squareColor);
        g2dBuffer.fillRect(x, y, 50, 50);

        // Narysuj bufor na ekranie
        g.drawImage(buffer, 0, 0, this);
    }

    private class MoveRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                moveSquare();
                try {
                    Thread.sleep(10); // Opóźnienie wątku, aby kontrolować prędkość ruchu
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
