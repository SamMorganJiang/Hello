package cn.main;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private int top;
    private Item[] item;

    ResizingArrayStack(int cap) {
        item = (Item[]) new Object[cap];
    }

    public int getTop() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    private void reSize(int max) {
        Item[] temp = (Item[]) new Object[max];
        System.arraycopy(this.item, 0, temp, 0, top);
        this.item = temp;
    }

    public void push(Item item) {
        if (this.item.length == top)
            reSize(this.item.length * 2);
        this.item[top++] = item;
    }

    public Item pop() {
        Item item = this.item[--top];
        this.item[top] = null;
        if (top > 0 && this.item.length / 4 == top)
            reSize(this.item.length / 2);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> e = new ResizingArrayStack<>(2);
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
