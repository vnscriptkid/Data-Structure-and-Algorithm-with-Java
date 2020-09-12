package com.vnscriptkid;

import java.util.Arrays;

public class Heap {
    private int[] values;
    private int count;

    public Heap() {
        values = new int[100];
        count = 0;
    }

    public int leftIndex(int index) {
        return 2 * index + 1;
    }

    public int rightIndex(int index) {
        return 2 * index + 2;
    }

    public int indexOfParent(int index) {
        double parentIndex = (((double)index - 1) / 2);
        return (int) Math.floor(parentIndex);
    }

    public int remove() {
        if (count == 0) {
            throw new IllegalStateException();
        }

        int removedItem = values[0];
        int lastItem = values[--count];
        values[0] = lastItem;
        int currentIndex = 0;
        // bubble down
        while (true) {
            if (!isValidNode(leftIndex(currentIndex)) && !isValidNode(rightIndex(currentIndex))) break;

            int rightValue = Integer.MIN_VALUE;
            int leftValue = Integer.MIN_VALUE;
            
            if (isValidNode(leftIndex(currentIndex))) {
                leftValue = values[leftIndex(currentIndex)];
            }

            if (isValidNode(rightIndex(currentIndex))) {
                rightValue = values[rightIndex(currentIndex)];
            }

            int indexOfBiggerChild = leftValue > rightValue ? leftIndex(currentIndex) : rightIndex(currentIndex);

            if (lastItem < values[indexOfBiggerChild]) {
                swap(currentIndex, indexOfBiggerChild);
                currentIndex = indexOfBiggerChild;
                continue;
            }
            break;
        }
        return removedItem;
    }

    public boolean isValidNode(int index) {
        return index < count;
    }

    public void insert(int item) {
        if (count == values.length) {
            throw new IllegalStateException();
        }

        values[count++] = item;

        int parentIndex = indexOfParent(count - 1);
        int currentIndex = count - 1;
        while (true) {
            if (parentIndex < 0) break;
            int parent = values[parentIndex];
            if (item > parent) {
                swap(parentIndex, currentIndex);
                // reset index
                currentIndex = parentIndex;
                parentIndex = indexOfParent(parentIndex);
                continue;
            }
            break;
        }
    }

    private void swap(int index1, int index2) {
        int temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    }

    @Override
    public String toString() {
        int[] activePart = Arrays.copyOfRange(values, 0, count);
        return Arrays.toString(activePart);
    }
}
