package com.vnscriptkid;

public class CountSort {
    public int[] sort(int[] numbers) {
        int[] result = new int[numbers.length];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // check if arr valid
        for (int element : numbers) {
            if (element < min)
                min = element;
            if (element > max)
                max = element;
        }
        if (min < 0) 
            throw new IllegalArgumentException();
        int[] counts = new int[max + 1];


        for (int i = 0; i < numbers.length; i++) {
            int value = numbers[i];
            counts[value]++;
        }

        int filledCount = 0;
        for (int value = 0; value < counts.length; value++) {
            if (filledCount == numbers.length)
                break;
            if (counts[value] > 0) {
                int times = counts[value];
                fillArray(result, value, times, filledCount);
                filledCount += times;
            }
        }
        return result;
    }

    public void fillArray(int[] arr, int value, int times, int filledCount) {
        while (true) {
            if (times <= 0)
                break;
            arr[filledCount] = value;
            filledCount++;
            times--;
        }
    }
}
