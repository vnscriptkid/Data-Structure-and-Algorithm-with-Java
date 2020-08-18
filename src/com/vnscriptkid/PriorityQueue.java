package com.vnscriptkid;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items;
    private int count;

    public PriorityQueue(int size) {
        items = new int[size];
        count = 0;
    }

    public void enqueue(int addedValue) {
        if (count == items.length)
            throw new IllegalStateException();

        int i;
        for (i = count - 1; i >= 0; i--) {
            int current = items[i];
            if (addedValue < current)
                items[i + 1] = current;
            else
                break;
        }
        items[i + 1] = addedValue;
        count++;
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

    @Override
    public String toString() {
        int[] activePart = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(activePart);
    }
}
