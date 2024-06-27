package kursJava;

import javax.swing.plaf.TableHeaderUI;
import java.util.LinkedList;

public class Swing_17_wait_notify {
    public static void main(String[] args) throws InterruptedException{

        PizzaHHH pizzeria = new PizzaHHH();

        Thread customer = new Thread(new Runnable() {
            @Override
            public void run() {
                pizzeria.waitForPizza();
            }
        });
        customer.start();

        Thread.sleep(3000);

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                pizzeria.pizzaMan();
            }
        });
        producer.start();

        customer.join();
    }
}

class PizzaHHH{
    private final LinkedList<String> delivery = new LinkedList<>();
    public void waitForPizza() {
        synchronized (delivery){
            System.out.println("Czekanie na dowóz");
            while (delivery.isEmpty()){
                try{
                    delivery.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("Pakunek dostarczony: "+delivery.poll());
        }
    }
    public void pizzaMan(){
        synchronized (delivery){
            System.out.println("Pizza pod drzwiami!");
            delivery.add("Margaritta");
            delivery.notify();
        }
    }
}