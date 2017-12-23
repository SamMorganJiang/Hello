package cn.main;

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
}
