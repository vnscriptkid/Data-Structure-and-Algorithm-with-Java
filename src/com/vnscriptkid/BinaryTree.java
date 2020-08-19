package com.vnscriptkid;

public class BinaryTree {
    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int value) {
        // create new node with value
        Node newNode = new Node(value);
        // empty tree
        if (root == null) {
            root = newNode;
            return;
        }
        // recursive loop to find place where to put
        Node current = root;
        while (true) {
            if (value > current.value) {
                // right
                if (current.right == null) {
                    current.right = newNode;
                    break;
                }
                current = current.right;
            }
            else {
                // left
                if (current.left == null) {
                    current.left = newNode;
                    break;
                }
                current = current.left;
            }
        }
    }

    public boolean find(int value) {
        if (root == null)
            return false;

        Node current = root;
        while (true) {
            if (current == null)
                break;
            if (current.value == value)
                return true;
            if (value > current.value)
                current = current.right;
            else
                current = current.left;
        }

        return false;

    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}
