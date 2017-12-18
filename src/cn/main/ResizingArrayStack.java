package cn.main;

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
        for (int i = 0; i < top; i++) {
            temp[i] = this.item[i];
        }
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
}
