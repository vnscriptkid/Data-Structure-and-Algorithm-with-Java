package com.vnscriptkid;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatedChar {
    public static char findInString(String input) {
        Map<Character, Integer> hashMap = new HashMap<>();
        char[] chars = input.toCharArray();

        for (char c : chars) {
            var count = hashMap.containsKey(c) ? hashMap.get(c) : 0;
            hashMap.put(c, count + 1);
        }
        for (char c : chars) {
            if (hashMap.get(c) == 1)
                return c;
        }
        return Character.MIN_VALUE;
    }
}
