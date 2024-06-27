package kursJava;

public class Swing_16_wątki {
    public static void main(String[] args) throws InterruptedException{

        Thread mainthreat = Thread.currentThread();

        TestThread thread1 = new TestThread("thread1",mainthreat);
        TestThread thread2 = new TestThread("thread2",mainthreat);

        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();
        System.out.println("Main threat");

    }
}

class TestThread extends Thread{
    Thread mainThread;
    public TestThread(String name, Thread mainThread){
        super(name);
        this.mainThread = mainThread;
    }

    @Override
    public void run() {
        System.out.println(getName() + " started.");
        try{
            for(int i = 0 ; i<4;i++){
                Thread.sleep(1000);
                System.out.println(getName() + " " +i);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(getName() + " finished.");
    }
}