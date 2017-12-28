package cn.main;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class quickUnion {
    private int[] id;
    private int count;

    quickUnion(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int getCount() {
        return count;
    }

    private int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        quickUnion qu = new quickUnion(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (qu.connected(p, q)) continue;
            qu.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(qu.getCount() + "components");
    }
}
