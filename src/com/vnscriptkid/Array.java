package com.vnscriptkid;

import java.security.InvalidParameterException;

public class Array {
    private int[] arr;
    private int count;

    public Array (int length) {
        arr = new int[length];
        count = 0;
    }

    public int getLength() {
        return arr.length;
    }

    public void insert(int item) {
        // if the array is full, resize it
        if (count == this.getLength()) {
            int[] newArray = new int[count + 1];
            // copy
            for (int i = 0; i < arr.length; i++) {
                newArray[i] = arr[i];
            }
            arr = newArray;
        }
        arr[count++] = item;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }
    }

    public int indexOf(int value) {
        for (int i = 0; i < count; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }

    public void removeAt(int index) {
        if (index >= count || index < 0) {
            throw new InvalidParameterException();
        }

        for (int i = index + 1; i < count; i++) {
            arr[i - 1] = arr[i];
        }
        count--;
    }


}
