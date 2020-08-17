package com.vnscriptkid;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Array arr = new Array(3);
        System.out.println("Length: " + arr.getLength());
        arr.insert(2);
        arr.insert(20);
        arr.insert(6);
        arr.insert(7);
        arr.print();
        System.out.println("Length now: " + arr.getLength());
    }
}
