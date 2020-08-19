package com.vnscriptkid;

public class Factorial {
    public static int usingLoop(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int usingRecursion(int n) {
        if (n == 1)
            return 1;
        return n * usingRecursion(n - 1);
    }
}
