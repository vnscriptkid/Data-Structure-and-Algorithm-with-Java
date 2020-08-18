package com.vnscriptkid;

import java.util.Arrays;

public class Stack {
    private int[] items;
    private int count;
    private final short MAX = 100;

    public Stack() {
        this.items = new int[MAX];
        this.count = 0;
    }

    public void push(int value) {
        if (count >= MAX)
            throw new StackOverflowError();
        items[count++] = value;
    }

    public int peek() {
        return items[count - 1];
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();
        return items[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void print() {
        StringBuffer result = new StringBuffer();
        String item;
        for (int i = 0; i < count; i++) {
            item = i != (count - 1) ? items[i] + ", " : items[i] + ";";
            result.append(item);
        }
        System.out.println(result);
    }

    @Override
    public String toString() {
        int[] activeItems = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(activeItems);
    }
}
