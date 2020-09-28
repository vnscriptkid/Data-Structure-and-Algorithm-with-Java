package com.vnscriptkid;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringUtils {
    public static int countVowels(String str) {
        if (str == null)
            return 0;
        String vowels = "aeiou";
        int count = 0;
        for (char currentChar : str.toLowerCase().toCharArray()) {
            if (vowels.contains(Character.toString(currentChar)))
                count++;
        }
        return count;
    }

    public static String reverseString(String str) {
        if (str == null)
            return "";
        StringBuilder result = new StringBuilder("");
        for (int i = str.length() - 1; i >= 1; i--) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }

    public static String reverseWords(String str) {
        if (str == null)
            return "";
        String[] words = str.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static String reverseWordsSecond(String str) {
        StringBuilder result = new StringBuilder("");
        String[] words = str.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i] + " ");
        }
        return result.toString().trim();
    }

    public static boolean areRotations(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;
        return str1.length() == str2.length()
            && str1.concat(str1).contains(str2);
    }

    public static String removeDuplicates(String str) {
        Set<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (char currentChar : str.toCharArray()) {
            if (!seen.contains(currentChar)) {
                result.append(currentChar);
                seen.add(currentChar);
            }
        }
        
        return result.toString();
    }

    public static char mostRepeatedChar(String str) {
        Map<Character, Integer> counts = new HashMap<>();
        
        for (char currentChar : str.toCharArray()) {
            if (counts.containsKey(currentChar)) {
                counts.put(currentChar, counts.get(currentChar) + 1);
            } else {
                counts.put(currentChar, 1);
            }            
        }

        char mostRepeatedChar = 'a';
        int repeatedTimes = -1;

        for (char currentChar : counts.keySet()) {
            if (counts.get(currentChar) > repeatedTimes) {
                repeatedTimes = counts.get(currentChar);
                mostRepeatedChar = currentChar;
            }
        }

        return mostRepeatedChar;
    }

    public static char mostRepeatedCharAnotherImpl(String str) {
        if (str.isEmpty() || str == null)
            throw new IllegalArgumentException();
        
        final int ASCII_SIZE = 256;
        int[] counts = new int[ASCII_SIZE];

        for (char currentChar : str.toCharArray()) {
            counts[currentChar]++;
        }

        int indexOfMostRepeatedChar = -1;
        int repeatedTimes = 0;

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > repeatedTimes) {
                repeatedTimes = counts[i];
                indexOfMostRepeatedChar = i;
            }
        }

        return (char) indexOfMostRepeatedChar;
    }

    public static String capitalize(String str) {
        if (str == null)
            return "";
        StringBuilder output = new StringBuilder();
        String[] words = str.trim().split(" ");
        for (String word : words) {
            if (!word.equals("")) {
                output
                    .append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
            }
        }
        return output.toString().trim();
    }

    public static String capitalizeAnotherImple(String str) {
        if (str == null || str.trim().isEmpty())
            return "";
        String[] words = str.trim().replaceAll(" +", " ").split(" ");
        String[] capitalizedWords = new String[words.length];

        int currentIndex = 0;

        for (String word : words) {
            word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
            capitalizedWords[currentIndex++] = word;
        }
        
        return String.join(" ", capitalizedWords);
    }

    public static boolean areAnagram(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;

        char[] arr1 = str1.toCharArray();
        Arrays.sort(arr1);
        
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr2);
            
        return Arrays.equals(arr1, arr2);
    }

    public static boolean areAnagramBetter(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;

        int[] counts = new int[256];

        for (char charInStr1 : str1.toCharArray()) {
            counts[charInStr1]++;
        }

        for (char charInStr2 : str2.toCharArray()) {
            if (counts[charInStr2] == 0)
                return false;
            counts[charInStr2]--;
        }

        for (int count : counts) {
            if (count > 0)
                return false;
        }

        return true;
    }

    public static boolean isPalindrome(String str) {
        if (str == null)
            return false;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static boolean isPalindromeSecond(String str) {
        if (str == null)
            return false;
        StringBuilder copy = new StringBuilder(str);
        copy.reverse();
        return str.equals(copy.toString());
    }

    public static boolean isPalindromeThird(String str) {
        if (str == null)
            return false;
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        }
        return true;
    }
}
