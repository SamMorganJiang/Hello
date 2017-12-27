package cn.main;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class SingleQueue<Item> implements Iterable<Item> {
    private int size;
    private Node head, tail;

    private class Node {
        Item item;
        Node next;
    }

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(Item item) {
        Node node = tail;
        tail = new Node();
        tail.item = item;
        tail.next = null;
        if (isEmpty()) {
            head = tail;
        } else {
            node.next = tail;
        }
        size++;
    }

    public Item pop() {
        Item item = head.item;
        head = head.next;
        if (isEmpty()) {
            tail = null;
        }
        size--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current == null;
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
