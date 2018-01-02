package cn.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

class SortCompare {
    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }
}

public class Sort {
    public static void main(String[] args) {
        System.out.println("Sorting algorithm test:");

        String alg1 = "Insertion";
        String alg2 = "Selection";
        String alg3 = "Shell";

        int N = 10000;
        int T = 100;

        double t1 = SortCompare.timeRandomInput(alg1, N, T);
        double t2 = SortCompare.timeRandomInput(alg2, N, T);
        double t3 = SortCompare.timeRandomInput(alg3, N, T);

        StdOut.printf("For %d random Doubles\n", N);
        StdOut.printf("  %s is %.1f times faster than %s\n", alg1, t2 / t1, alg2);
        StdOut.printf("  %s is %.1f times faster than %s\n", alg3, t1 / t3, alg1);
    }
}
