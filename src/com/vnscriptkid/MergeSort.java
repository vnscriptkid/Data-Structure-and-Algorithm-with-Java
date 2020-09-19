package com.vnscriptkid;

import java.util.Arrays;

public class MergeSort {
    private int[] input;

    public MergeSort(int[] input) {
        this.input = input;
    }
    
    public int[] sort() {
        sort(input, 0, input.length - 1);
        return input;
    }

    public void sort(int[] source, int leftIndex, int rightIndex) {
        if (rightIndex == leftIndex)
            return;

        int middleIndex = (rightIndex + leftIndex) / 2;

        int[] leftPart = Arrays.copyOfRange(input, leftIndex, middleIndex + 1);
        int[] rightPart = Arrays.copyOfRange(input, middleIndex + 1, rightIndex + 1);

        sort(leftPart, leftIndex, middleIndex);
        sort(rightPart, middleIndex + 1, rightIndex);
        merge(source, leftPart, rightPart);
    }

    public void merge(int[] result, int[] leftPart, int[] rightPart) {
        int leftIndexNow = 0;
        int rightIndexNow = 0;
        int indexOfResult = 0;
        while (true) {
            
            if (leftIndexNow > leftPart.length - 1 && rightIndexNow > rightPart.length - 1)
                break;
            if (leftIndexNow > leftPart.length - 1) {
                copyTillTheEnd(result, rightPart, rightIndexNow, indexOfResult);
                break;
            }
            if (rightIndexNow > rightPart.length - 1) {
                copyTillTheEnd(result, leftPart, leftIndexNow, indexOfResult);
                break;
            }

            int min;
            if (leftPart[leftIndexNow] <= rightPart[rightIndexNow]) {
                min = leftPart[leftIndexNow++];
            } else {
                min = rightPart[rightIndexNow++];
            }
            result[indexOfResult++] = min;
        }
    }

    private void copyTillTheEnd(int[] result, int[] source, int indexNow, int indexOfResult) {
        while (true) {
            if (indexNow > source.length - 1)
                break;
            result[indexOfResult++] = source[indexNow++];
        }
    }
}
