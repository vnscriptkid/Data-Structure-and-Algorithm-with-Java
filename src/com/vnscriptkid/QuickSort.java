package com.vnscriptkid;

public class QuickSort {
    public int[] sort(int[] numbers) {
        partition(numbers, 0, numbers.length -1);
        return numbers;
    }

    public void partition(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex)
            return;
        // pick the pivot
        int pivot = arr[rightIndex];
        // put pivot in right place
        int boundaryIndex = leftIndex - 1;
        for (int i = leftIndex; i < rightIndex; i++) {
            int currentNumber = arr[i];
            // case 1: >= pivot
            if (currentNumber >= pivot) {
                continue;
            }
            // case 2: < pivot
            else {
                swap(arr, ++boundaryIndex, i); 
            }
        }
        swap(arr, boundaryIndex + 1, rightIndex);
        // partition left
        if (boundaryIndex != leftIndex - 1) {
            partition(arr, leftIndex, boundaryIndex);
        }
        // partition right
        if (boundaryIndex != rightIndex - 1) {
            partition(arr, boundaryIndex + 2, rightIndex);
        }
    }

    public void swap(int[] numbers, int firstIndex, int secondIndex) {
        if (firstIndex == secondIndex)
            return;
        int temp = numbers[firstIndex];
        numbers[firstIndex] = numbers[secondIndex];
        numbers[secondIndex] = temp;
    }
}
