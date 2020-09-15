package com.vnscriptkid;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    Map<String, Node> nodes = new HashMap<>();
    Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node newNode = new Node(label);
        nodes.putIfAbsent(label, newNode);
        adjacencyList.put(newNode, new ArrayList<>());
    }   

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null) 
            throw new IllegalStateException();
        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeNode(String label) {
        Node foundNode = nodes.get(label);
        if (foundNode == null) {
            throw new IllegalStateException();
        }
        // remove any edge pointing to X
        for (Node source : adjacencyList.keySet()) {
            adjacencyList.get(source).remove(foundNode);
        }
        // remove adjacencyList starting from X
        adjacencyList.remove(foundNode);
        // remove X from nodes
        nodes.remove(label);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null) 
            throw new IllegalStateException();
        adjacencyList.get(fromNode).remove(toNode);
    }

    public void print() {
        for (Node node : adjacencyList.keySet()) {
            if (adjacencyList.get(node).size() > 0) {
                System.out.println(node + " is connected to " + adjacencyList.get(node).toString());
            }
        }
    }

    public void depthFirstSearch(String startingLabel) {
        Set<Node> visitedNodes = new HashSet<>();
        Node startingNode = nodes.get(startingLabel);
        depthFirstSearch(startingNode, visitedNodes);
    }

    private void depthFirstSearch(Node currentNode, Set<Node> visitedNodes) {
        System.out.println(currentNode.label);
        visitedNodes.add(currentNode);
        for (Node connectedNode : adjacencyList.get(currentNode)) {
            if (!visitedNodes.contains(connectedNode))
                depthFirstSearch(connectedNode, visitedNodes);
        }
    }

    public void dfsUsingStack(String startingLabel) {
        Set<Node> visitedNodes = new HashSet<>();
        Node startingNode = nodes.get(startingLabel);
        if (startingNode == null)
            throw new IllegalArgumentException();
        Stack<Node> stack = new Stack<>();
        stack.push(startingNode);
        Node nextNode = null;
        while (!stack.isEmpty()) {
            nextNode = stack.pop();

            if (visitedNodes.contains(nextNode))
                continue;

            System.out.println(nextNode.label);
            visitedNodes.add(nextNode);

            for (Node connectedNode : adjacencyList.get(nextNode)) {
                if (!visitedNodes.contains(connectedNode))
                    stack.push(connectedNode);
            }
        }
    }

    public void bfsUsingQueue(String startingLabel) {
        Set<Node> visitedNodes = new HashSet<>();
        Node startingNode = nodes.get(startingLabel);
        if (startingNode == null)
            throw new IllegalArgumentException();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(startingNode);
        while (!queue.isEmpty()) {
            Node nextNode = queue.remove();

            if (visitedNodes.contains(nextNode))
                continue;
            
            System.out.println(nextNode.label);
            visitedNodes.add(nextNode);

            for (Node connectedNode : adjacencyList.get(nextNode)) {
                if (!visitedNodes.contains(connectedNode))
                    queue.add(connectedNode);
            }
        }
    }

    public void topologicalSorting() {
        Stack<Node> stack = new Stack<>();
        Set<Node> visistedNodes = new HashSet<>();
        for (Node node : adjacencyList.keySet()) {
            DFS(node, stack, visistedNodes);
        }
        List<String> sortedList = new ArrayList<>();
        while (!stack.isEmpty()) {
            sortedList.add(stack.pop().label);
        }
        System.out.println(sortedList.toString());
    }

    private void DFS(Node node, Stack<Node> stack, Set<Node> visistedNodes) {
        if (visistedNodes.contains(node))
            return;
        visistedNodes.add(node);
        for (Node connectedNode: adjacencyList.get(node)) {
            if (!visistedNodes.contains(connectedNode))
                DFS(connectedNode, stack, visistedNodes);
        }
        stack.push(node);
    }

    public boolean cycleDetection() {
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while (!all.isEmpty()) {
            Node currentNode = all.iterator().next();
            if (hasCycle(currentNode, all, visiting, visited))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);
        for (Node connectedNode : adjacencyList.get(node)) {
            if (visiting.contains(connectedNode))
                return true;
            if (visited.contains(connectedNode))
                continue;
            if(hasCycle(connectedNode, all, visiting, visited))
                return true;
        }
        visited.add(node);
        visiting.remove(node);
        return false;
    } 
}
