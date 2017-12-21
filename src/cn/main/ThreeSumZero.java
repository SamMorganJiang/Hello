package cn.main;

import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

public class ThreeSumZero {
    private ThreeSumZero() {
    }

    public static int normalCount(int[] a) {
        int cnt = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    public static int fastCount(int[] a) {
        int cnt = 0;
        int n = a.length;

        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (BinarySearch.indexOf(a, -a[i] - a[j]) > j) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
