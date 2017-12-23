package cn.main;

import edu.princeton.cs.algs4.DoublingTest;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.function.DoubleBinaryOperator;

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

        int N = Integer.parseInt("1000");
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-1000000, 1000000);
        }

        Stopwatch timerN = new Stopwatch();
        int cnt = ThreeSumZero.normalCount(a);
        double time = timerN.elapsedTime();
        StdOut.println("normalcount: " + cnt + " triples " + time + " seconds");

        Stopwatch timerF = new Stopwatch();
        cnt = ThreeSumZero.fastCount(a);
        time = timerF.elapsedTime();
        StdOut.println("fastcount: " + cnt + " triples " + time + " seconds");

        double prev = DoublingTest.timeTrial(125);
        for (int i = 250; i < 64000; i += i) {
            time = DoublingTest.timeTrial(i);
            StdOut.printf("%6d %7.1f ", i, time);
            StdOut.printf("%5.1f\n", time / prev);
            prev = time;
        }

        //CapacityStack<String> e = new CapacityStack<String>(2);
        //ResizingArrayStack<String> e = new ResizingArrayStack<>(2);
        //SingleStack<String> e = new SingleStack<>();
        SingleQueue<String> e = new SingleQueue<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!s.equals("-")) {
                e.push(s);
            } else if (!e.isEmpty()) {
                StdOut.print(e.pop() + " ");
            }
        }
    }
}
