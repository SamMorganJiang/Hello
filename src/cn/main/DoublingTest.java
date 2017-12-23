package cn.main;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {
    private static final int MAX = 1000000;
    private static int[] a;

    private DoublingTest(int N) {
        a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
    }

    public static double normalTimeTrial() {
        Stopwatch timer = new Stopwatch();
        ThreeSumZero.normalCount(a);
        return timer.elapsedTime();
    }

    public static double fastTimeTrial() {
        Stopwatch timer = new Stopwatch();
        ThreeSumZero.fastCount(a);
        return timer.elapsedTime();
    }
}
