package cn.main;

import edu.princeton.cs.algs4.DoublingTest;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

abstract class Demo {
    abstract public void func();
}

class EasyThread extends Thread {
    private int priority;

    public EasyThread(int p) {
        priority = p;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        for (int i = 0; i < 3; i++) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()
                    + " p : " + Thread.currentThread().getPriority()
                    + " count : " + i);
        }
    }
}

class ThreadSafeDeal implements Runnable {
    private static int ticket = 10;

    public void run() {
        while (ticket > 0) {
            //synchronized (this) {
            synchronized (" ") {
                System.out.println(Thread.currentThread().getName() + " " + ticket);
                ticket--;
            }
        }
    }
}

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Demo dm = new Demo() {
            @Override
            public void func() {
                System.out.println("Demo");
            }
        };

        dm.func();

        EasyThread mt1 = new EasyThread(1);
        mt1.start();

        EasyThread mt2 = new EasyThread(2);
        mt2.start();

        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " p : " + Thread.currentThread().getPriority()
                    + " count : " + i);
        }

        ThreadSafeDeal ts1 = new ThreadSafeDeal();
        new Thread(ts1).start();

        ThreadSafeDeal ts2 = new ThreadSafeDeal();
        new Thread(ts2).start();
    }
}
