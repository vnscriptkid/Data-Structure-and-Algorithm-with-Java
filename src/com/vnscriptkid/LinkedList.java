package com.vnscriptkid;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node first;
    private Node last;
    private int count;

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.count = 0;
    }

    private Node createNewNode(int value) {
        return new Node(value, null);
    }

    public int size() {
        return count;
    }

    public Node addFirst(int value) {
        Node newNode = createNewNode(value);
        // empty list
        if (isEmpty())
            first = last = newNode;
        else {
            newNode.next = first;
            first = newNode;
        }
        count++;
        return newNode;
    }

    public Node addLast(int value) {
        Node newNode = createNewNode(value);
        // empty list
        if (isEmpty())
            first = last = newNode;
        else {
            last.next = newNode;
            last = newNode;
        }
        count++;
        return newNode;
    }

    public void deleteFirst() {
        // empty list
        if (isEmpty())
            throw new NoSuchElementException();
        // length == 1
        if (first.next == null)
            first = last = null;
        else {
            Node newFirst = first.next;
            first.next = null;
            first = newFirst;
        }
        count--;
    }

    public void deleteLast() {
        // empty list
        if (isEmpty())
            throw new NoSuchElementException();
        // length == 1
        if (first.next == null)
            first = last = null;
        else {
            Node previousLast = getPreviousLast();
            previousLast.next = null;
            last = previousLast;
        }
        count--;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int indexOf(int value) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (value == current.value)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public void print() {
        Node current = first;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public int[] toArray() {
        int[] arr = new int[count];
        int index = 0;
        Node current = first;
        while (current != null) {
            arr[index++] = current.value;
            current = current.next;
        }
        return arr;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private Node getPreviousLast() {
        if (first == last)
            throw new NoSuchElementException();
        Node current = first;
        while (true) {
            if (current.next == last) break;
            current = current.next;
        }
        return current;
    }

    public void reverse() {
        if (first == last) return;
        Node[] refList = new Node[count];
        int index = 0;
        Node current = first;
        while (current != null) {
            refList[index++] = current;
            current = current.next;
        }
        first = refList[refList.length - 1];
        for (int i = refList.length - 1; i > 0; i--) {
            refList[i].next = refList[i - 1];
        }
        refList[0].next = null;
        last = refList[0];
    }

    public int getKthFromTheEnd(int k) {
        if (first == last) throw new IllegalStateException();
        if (k < 1 || k >= count) throw new IllegalArgumentException();
        Node left, right;
        left = right = first;
        // move right to the right k steps
        int step = 0;
        while (step < k) {
            step++;
            right = right.next;
        }
        // right is k steps away from left
        // move both to the right till, 'right' reaches the end
        while (right != last) {
            right = right.next;
            left = left.next;
        }
        // left is now k-th from the end
        return left.value;
    }
}
