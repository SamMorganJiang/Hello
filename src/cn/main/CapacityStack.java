package cn.main;

public class CapacityStack<Item> {
    private int num;
    private Item[] item;

    CapacityStack(int cap) {
        item = (Item[]) new Object[cap];
    }

    public int getNum() {
        return num;
    }

    public Item[] getItem() {
        return item;
    }

    private void reDefNum(int len) {
        Item[] temp = (Item[]) new Object[len];
        System.arraycopy(this.item, 0, temp, 0, num);
        this.item = temp;
    }

    public boolean isEmpty() {
        return this.getNum() == 0;
    }

    public void push(Item item) {
        if (num == this.item.length)
            reDefNum(this.item.length * 2);
        this.item[num++] = item;
    }

    public Item pop() {
        Item item = this.item[--num];
        this.item[num] = null;
        if (num > 0 && num == this.item.length / 4)
            reDefNum(this.item.length / 2);
        return item;
    }
}
