package com.vnscriptkid;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpression {

    private static final List<Character> openings = Arrays.asList('[', '{', '(', '<');
    private static final List<Character> closings = Arrays.asList(']', '}', ')', '>');

    public static boolean check(String input) {

        var stack = new Stack<Character>();
        for (char c :
                input.toCharArray()) {
            // case 1: opening
            if (openings.contains(c)) {
                stack.push(c);
            }
            // case 2: closing
            else if (closings.contains(c)) {
                char peek = stack.pop();
                if (!isCharactersMatched(peek, c)) return false;
            }
            // case 3: others skip
        }
        return stack.isEmpty();
    }

    private static boolean isCharactersMatched(char left, char right) {
        return openings.indexOf(left) == closings.indexOf(right);
    }
}
