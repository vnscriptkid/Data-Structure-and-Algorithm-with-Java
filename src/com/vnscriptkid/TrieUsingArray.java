package com.vnscriptkid;

public class TrieUsingArray {
    public static short ALPHABET_SIZE = 26;
    
    private class Node {
        private char value;
        private Node[] children = new Node[ALPHABET_SIZE];;
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }
    }

    private Node root;

    public TrieUsingArray() {
        this.root = new Node(' ');
    }

    public void insert(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            int indexOfChar = c - 97;
            if (current.children[indexOfChar] == null) {
                current.children[indexOfChar] = new Node(c);
            }
            current = current.children[indexOfChar];
        }
        current.isEndOfWord = true;
    }
}
