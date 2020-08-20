package com.vnscriptkid;

import java.util.Objects;

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

    public BinaryTree(Node root) {
        this.root = root;
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

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) { // ROOT, left, right
        if (root == null)
            return;
        // print root
        System.out.println(root.value + "; ");
        // print left
        traversePreOrder(root.left);
        // print right
        traversePreOrder(root.right);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) { // left, ROOT, right
        if (root == null)
            return;
        traverseInOrder(root.left);
        System.out.println(root.value);
        traverseInOrder(root.right);
    }

    public void traversePostOrder() {
        traverseInOrder(root);
    }

    private void traversePostOrder(Node root) { // left, right, ROOT
        if (root == null)
            return;
        traverseInOrder(root.left);
        traverseInOrder(root.right);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) return -1;
        if (isLeafNode()) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int minValue() {
        if (root == null)
            throw new IllegalStateException();
        return minValue(root);
    }

    private int minValue(Node root) {
        if (root == null)
            return Integer.MAX_VALUE;
        if (isLeafNode())
            return root.value;

        int leftMin = minValue(root.left);
        int rightMin = minValue(root.right);

        return Math.min(Math.min(leftMin, rightMin), root.value);
    }

    private boolean isLeafNode() {
        return root.left == null && root.right == null;
    }


    public int minValueFast() {
        return minValueFast(root);
    }

    private int minValueFast(Node root) {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTree that = (BinaryTree) o;
        return equals(root, that.root);
    }

    private boolean equals(Node node1, Node node2) {
        // both null
        if (node1 == null && node2 == null)
            return true;
        // either is null
        if (node1 == null || node2 == null)
            return false;
        // both not null
        boolean leftEqual = equals(node1.left, node2.left);
        boolean rightEqual = equals(node1.right, node2.right);

        return leftEqual && rightEqual && node1.value == node2.value;
    }


    @Override
    public int hashCode() {
        return Objects.hash(root);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}
