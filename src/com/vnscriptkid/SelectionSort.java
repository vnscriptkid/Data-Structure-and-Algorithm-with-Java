package com.vnscriptkid;

public class SelectionSort {
    public int[] sort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i + 1;
            int minValue = Integer.MAX_VALUE;
            for (int j = i + 1 ; j < numbers.length; j++) {
                if (numbers[j] < minValue) {
                    minValue = numbers[j];
                    minIndex = j;
                }
            }
            if (numbers[minIndex] < numbers[i])
                swap(numbers, i, minIndex);
        }
        return numbers;
    }

    public void swap(int[] numbers, int firstIndex, int secondIndex) {
        int temp = numbers[firstIndex];
        numbers[firstIndex] = numbers[secondIndex];
        numbers[secondIndex] = temp;
    }
}
