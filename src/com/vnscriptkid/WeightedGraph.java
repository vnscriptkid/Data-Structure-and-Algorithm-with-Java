package com.vnscriptkid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph {
    private class Node {
        String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private class Edge {
        Node fromNode;
        Node toNode;
        int weight;

        public Edge(Node fromNode, Node toNode, int weight) {
            this.fromNode = fromNode;
            this.toNode = toNode;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Path from " + fromNode + " to " + toNode + " has weight of " + weight;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Edge>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node newNode = new Node(label);
        nodes.putIfAbsent(label, newNode);
        adjacencyList.putIfAbsent(newNode, new ArrayList<>());
    }

    public void addEdge(String fromNodeLabel, String toNodeLabel, int weight) {
        Node fromNode = nodes.get(fromNodeLabel);
        Node toNode = nodes.get(toNodeLabel);

        if (fromNode == null || toNode == null) {
            throw new IllegalArgumentException("Node does not exist");
        }
        
        adjacencyList.get(fromNode).add(new Edge(fromNode, toNode, weight));
        adjacencyList.get(toNode).add(new Edge(toNode, fromNode, weight));
    }

    public void print() {
        for (Node node : nodes.values()) {
            for (Edge edge : adjacencyList.get(node)) {
                System.out.println(edge);                
            }                        
        }
    }
}
