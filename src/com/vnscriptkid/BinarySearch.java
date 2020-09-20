package com.vnscriptkid;

public class BinarySearch {
    public int findUsingRecursion(int[] input, int value) {
        return findUsingRecursion(input, value, 0, input.length - 1);
    }

    private int findUsingRecursion(int[] input, int value, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex && input[leftIndex] != value)
            return -1;
        
        int middleIndex = (leftIndex + rightIndex) / 2;
        int middleValue = input[middleIndex];

        if (middleValue == value)
            return middleIndex;
        
        else if (value > middleValue)
            return findUsingRecursion(input, value, middleIndex + 1, rightIndex);

        else
            return findUsingRecursion(input, value, leftIndex, middleIndex - 1);

    }

    public int findUsingLoop(int[] input, int value) {
        int leftIndex = 0;
        int rightIndex = input.length - 1;
        
        while (true) {
            if (leftIndex > rightIndex)
                break;
            int middleIndex = (leftIndex + rightIndex) / 2;
            int middleValue = input[middleIndex];

            if (middleValue == value)
                return middleIndex;
            if (value > middleValue) {
                leftIndex = middleIndex + 1;
                continue;
            }
            if (value < middleValue) {
                rightIndex = middleIndex - 1;
                continue;
            }
        }
        
        return -1;
    }
}
