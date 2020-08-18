package com.vnscriptkid;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
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
}
