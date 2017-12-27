package cn.main;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {
    private static final int MAX = 1000000;
    private static int[] a;
    private static int cnt;

    private DoublingTest(int N) {
        a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
    }

    public static DoublingTest getObject(int N) {
        return new DoublingTest(N);
    }

    public static int getMAX() {
        return MAX;
    }

    public int getCnt() {
        return cnt;
    }

    public double normalTimeTrial() {
        Stopwatch timer = new Stopwatch();
        cnt = ThreeSumZero.normalCount(a);
        return timer.elapsedTime();
    }

    public double fastTimeTrial() {
        Stopwatch timer = new Stopwatch();
        cnt = ThreeSumZero.fastCount(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        DoublingTest target = DoublingTest.getObject(1000);
        double time = target.normalTimeTrial();
        StdOut.println("normalcount: " + target.getCnt() + " triples " + time + " seconds");

        time = target.fastTimeTrial();
        StdOut.println("fastcount: " + target.getCnt() + " triples " + time + " seconds");

        double prev = edu.princeton.cs.algs4.DoublingTest.timeTrial(125);
        for (int i = 250; i < 64000; i += i) {
            time = edu.princeton.cs.algs4.DoublingTest.timeTrial(i);
            StdOut.printf("%6d %7.1f ", i, time);
            StdOut.printf("%5.1f\n", time / prev);
            prev = time;
        }
    }
}
