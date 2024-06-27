package kursJava;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Swing_g2d extends JFrame{

    public static void main(String[] args) {
        Swing_g2d frame = new Swing_g2d();
        frame.setSize(200,200);

        Malunek malunek = new Malunek();
        frame.add(malunek);

        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
class Malunek extends JComponent{

    Image img;
    public Malunek() {
        super();
        img = new ImageIcon("mapka_gra.jpg").getImage();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img,0,0,200,200,this);
        g2d.setColor(Color.RED);
        g2d.draw(new Line2D.Float(0.0f,10.0f,220.0f,200.0f));

        GradientPaint gp = new GradientPaint(2,2,Color.YELLOW,25,25,Color.RED,true);
        g2d.setPaint(gp);
        g2d.fillRect(10,10,100,50);
    }

}
