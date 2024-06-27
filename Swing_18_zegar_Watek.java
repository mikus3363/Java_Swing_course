package kursJava;

import javax.swing.*;
import java.time.LocalDateTime;

public class Swing_18_zegar_Watek extends JFrame implements Runnable {
    private Thread thread;
    String hour,minutes,secounds;
    JLabel zegar;

    public Swing_18_zegar_Watek(){
        zegar = new JLabel("",JLabel.CENTER);
        zegar.setBounds(5,5,100,40);
        this.add(zegar);
        this.setSize(100,80);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);

        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {
        try{
            while(true){
                LocalDateTime today = LocalDateTime.now();
                hour = ""+today.getHour();
                minutes = String.format("%02d",today.getMinute());
                secounds = String.format("%02d",today.getSecond());

                zegar.setText(hour+":"+minutes+":"+secounds);
                thread.sleep(1000);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Swing_18_zegar_Watek clock = new Swing_18_zegar_Watek();
    }
}
