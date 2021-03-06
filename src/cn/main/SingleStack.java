package cn.main;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class SingleStack<Item> implements Iterable<Item> {
    private int size;
    private Node top;

    private class Node {
        Item item;
        Node next;
    }

    public int getSize() {
        return size;
    }

    public Node getTop() {
        return top;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Item item) {
        Node node = top;
        top = new Node();
        top.item = item;
        top.next = node;
        size++;
    }

    public Item pop() {
        Item item = top.item;
        top = top.next;
        size--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private Node current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        SingleStack<String> e = new SingleStack<>();
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
