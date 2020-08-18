package com.vnscriptkid;

import java.util.Arrays;

public class Main {

    public static void linkedlist() {
        LinkedList list = new LinkedList();
        System.out.println(Arrays.toString(list.toArray()));
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(4);
        // 1, 2, 3, 4
        int threeAwayEnd = list.getKthFromTheEnd(3);
        System.out.println("3 steps from end: " + threeAwayEnd);
        System.out.println(Arrays.toString(list.toArray()));
        list.reverse();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("index of 3: " + list.indexOf(3));
        System.out.println("contains 2: " + list.contains(2));
        System.out.println("contains 5: " + list.contains(5));
        list.deleteFirst();
        list.deleteLast();
        System.out.println("after delete first and last: ");
        list.print();
        System.out.println("count now: " + list.size());
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void expressionEvaluation() {
        boolean shouldTrue = BalancedExpression.check("{([thanh]<cool>)[boy]}");
        boolean shouldFalse = BalancedExpression.check("([thanh]<cool>)[boy}");
        System.out.println("shouldTrue: " + shouldTrue);
        System.out.println("shouldFalse: " + shouldFalse);
    }

    public static void reverseString() {
        String result = ReverseStringUsingStack.reverse("thanh");
        System.out.println(result);
    }

    public static void stackImplementation() {
        Stack stack = new Stack();
        System.out.println("is empty: " + stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        stack.print();
        System.out.println("top now: " + stack.peek());
        stack.pop();
        System.out.println("pop one, top now: " + stack.peek());
        System.out.println("is empty: " + stack.isEmpty());
        stack.pop();
        stack.pop();
        System.out.println("is empty: " + stack.isEmpty());
    }

    public static void main(String[] args) {
        stackImplementation();
    }
}
