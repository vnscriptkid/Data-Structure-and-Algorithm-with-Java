package com.vnscriptkid;

import java.util.Arrays;

public class MyArrayDeque {

    private final static short MAX = 5;
    private int[] items;
    private int head;
    private int count;

    public MyArrayDeque() {
        items = new int[MAX];
        head = 0;
        count = 0;
    }

    public void enqueue(int value) {
        if (isFull())
            throw new IllegalStateException();
        items[getNextTailIndex()] = value;
        count++;
    }

    private int getNextTailIndex() {
        return (head + count) % MAX;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        int dequeued = items[head];
        items[head++] = 0;
        count--;
        return dequeued;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return items[head];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == MAX;
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
