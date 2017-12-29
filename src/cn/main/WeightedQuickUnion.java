package cn.main;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnion {
    private int[] root;
    private int[] rank;
    private int count;

    WeightedQuickUnion(int N) {
        count = N;
        root = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int getCount() {
        return count;
    }

    private int find(int p) {
        while (p != root[p]) p = root[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        if (rank[p] < rank[q]) {
            root[pRoot] = qRoot;
            rank[qRoot] += pRoot;
        } else {
            root[qRoot] = pRoot;
            rank[pRoot] += qRoot;
        }
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnion w = new WeightedQuickUnion(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (w.connected(p, q)) continue;
            w.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(w.getCount() + "components");
    }
}
