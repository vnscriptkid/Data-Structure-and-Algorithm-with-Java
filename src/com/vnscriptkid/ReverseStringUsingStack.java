package com.vnscriptkid;

import java.util.Stack;

public class ReverseStringUsingStack {
    public static String reverse(String input) {
        if (input == null)
            throw new IllegalArgumentException();
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        StringBuffer result = new StringBuffer();
        while (!stack.isEmpty()) {
            result = result.append(stack.pop());
        }
        return result.toString();
    }
}
