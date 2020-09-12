package com.vnscriptkid;

import java.util.HashMap;

public class TrieUsingHashTable {
    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        public boolean containsKey(char ch) {
            return children.containsKey(ch);
        }

        public void addNode(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChildNode(char ch) {
            return children.get(ch);
        }

        public void endWordHere() {
            this.isEndOfWord = true;
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }
    }

    private Node root;

    public TrieUsingHashTable() {
        this.root = new Node(' ');
    }

    public void insert(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            if (!current.containsKey(c)) {
                current.addNode(c);
            }
            current = current.getChildNode(c);
        }
        current.endWordHere();
    }

    public boolean isEmpty() {
        return root.children.isEmpty();
    }

    public boolean contains(String word) {
        if (isEmpty())
            throw new IllegalStateException();
        if (word.isEmpty())
            throw new IllegalArgumentException();
        Node current = root;
        for (char c : word.toCharArray()) {
            if (!current.containsKey(c))
                return false;
            current = current.getChildNode(c);
        }
        return current.isEndOfWord;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        System.out.print(root.value);
        for (Node child : root.getChildren()) {
            traversePreOrder(child);
        }
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        for (Node child : root.getChildren()) {
            traversePostOrder(child);
        }
        System.out.print(root.value);
    }
}
