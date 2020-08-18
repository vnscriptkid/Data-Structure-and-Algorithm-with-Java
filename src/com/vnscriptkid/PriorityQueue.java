package com.vnscriptkid;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items;
    private int count;

    public PriorityQueue(int size) {
        items = new int[size];
        count = 0;
    }

    public void enqueue(int value) {
        if (isFull())
            throw new IllegalStateException();

        int indexToInsert = shiftRightToInsert(value);
        items[indexToInsert] = value;
        count++;
    }

    private int shiftRightToInsert(int value) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            int current = items[i];
            if (value < current)
                items[i + 1] = current;
            else
                break;
        }
        return i + 1;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        return items[--count];
    }

    public int peek() {
        return items[count - 1];
    }

    private boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        int[] activePart = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(activePart);
    }
}
