package com.vnscriptkid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieUsingHashTable {
    private class Node {
        private final char value;
        private final HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(final char value) {
            this.value = value;
        }

        public boolean containsKey(final char ch) {
            return children.containsKey(ch);
        }

        public void addNode(final char ch) {
            children.put(ch, new Node(ch));
        }

        public void deleteNode(final char ch) {
            children.remove(ch);
        }

        public Node getChildNode(final char ch) {
            return children.get(ch);
        }

        public void endWordHere() {
            this.isEndOfWord = true;
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }
    }

    private final Node root;

    public TrieUsingHashTable() {
        this.root = new Node(' ');
    }

    public void insert(final String word) {
        Node current = root;
        for (final char c : word.toCharArray()) {
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

    public boolean contains(final String word) {
        if (isEmpty())
            return false;
        if (word.isEmpty())
            throw new IllegalArgumentException();
        Node current = root;
        for (final char c : word.toCharArray()) {
            if (!current.containsKey(c))
                return false;
            current = current.getChildNode(c);
        }
        return current.isEndOfWord;
    }

    public void traversePreOrder() {
        final List<String> words = new ArrayList<>();
        traversePreOrder(root, "", words);
        for (final String string : words) {
            System.out.println(string);
        }
    }

    private void traversePreOrder(final Node root, final String currentWord, final List<String> words) {
        if (root.isEndOfWord)
            words.add(currentWord);
        for (final Node child : root.getChildren()) {
            traversePreOrder(child, currentWord + child.value, words);
        }
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(final Node root) {
        for (final Node child : root.getChildren()) {
            traversePostOrder(child);
        }
        System.out.print(root.value);
    }

    public void delete(final String word) {
        delete(root, word, 0);
    }

    private void delete(final Node root, final String word, final int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }
        final char currentChar = word.charAt(index);
        final Node childNode = root.getChildNode(currentChar);
        if (childNode == null)
            return;
        delete(childNode, word, index + 1);
        if (childNode.children.size() == 0 && !childNode.isEndOfWord) {
            root.deleteNode(currentChar);
        }
    }

    public List<String> autoCompletion(final String prefix) {
        if (prefix == null)
            throw new IllegalArgumentException();
        final List<String> foundWords = new ArrayList<>();
        final Node endOfPrefix = getToEndOfPrefix(prefix);
        autoCompletion(endOfPrefix, prefix, foundWords);
        return foundWords;
    }

    private void autoCompletion(Node currentNode, String currentWord, List<String> foundWords) {
        if (currentNode == null)
            return;
        if (currentNode.isEndOfWord)
            foundWords.add(currentWord);
        for (Node childNode : currentNode.getChildren()) {
            autoCompletion(childNode, currentWord + childNode.value, foundWords);
        }
    }

    public Node getToEndOfPrefix(String prefix) {
        Node currentNode = root;
        for (char currentChar : prefix.toCharArray()) {
            if (!currentNode.containsKey(currentChar))
                return null;
            currentNode = currentNode.getChildNode(currentChar);
        }
        return currentNode;
    }
}
