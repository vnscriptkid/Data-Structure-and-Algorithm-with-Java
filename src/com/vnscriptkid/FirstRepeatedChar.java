package com.vnscriptkid;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedChar {
    public static char find(String input) {
        Set<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (set.contains(c))
                return c;
            set.add(c);
        }
        return Character.MIN_VALUE;
    }
}
