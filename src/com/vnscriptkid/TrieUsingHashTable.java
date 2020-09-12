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
}
