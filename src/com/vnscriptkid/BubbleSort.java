package com.vnscriptkid;

public class BubbleSort {
    private int[] numbers;

    public BubbleSort(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] sort() {
        for (int bubbleTime = 0; bubbleTime <= numbers.length - 2; bubbleTime++) {
            for (int index = 1; index <= numbers.length - 1 - bubbleTime; index++) { // (length - 1) times
                if (numbers[index - 1] > numbers[index])
                    swap(index, index - 1);
            }
        } 
        return numbers;
    }

    public void swap(int firstIndex, int secondIndex) {
        int temp = numbers[firstIndex];
        numbers[firstIndex] = numbers[secondIndex];
        numbers[secondIndex] = temp;
    }
}
