package com.vnscriptkid;

public class InsertionSort {
    public int[] sort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            // sorted part: 0 -> i - 1
            // insert i to sorted part at right position
            int valueToInsert = numbers[i];
            insert(numbers, valueToInsert, i);
        }
        return numbers;
    }

    // 3 _ | 5
    public void insert(int[] numbers, int valueToInsert, int indexToInsert) {
        int i;
        for (i = indexToInsert - 1; i >= 0; i--) {
            if (numbers[i] > valueToInsert) {
                // move right 1 step
                numbers[i + 1] = numbers[i];
                continue;
            }
            break;
        }
        numbers[i + 1] = valueToInsert;
    }
    
}
