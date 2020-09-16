package com.vnscriptkid;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class WeightedGraphOOP {
    private class Node {
        String label;
        List<Edge> edges;

        public Node(String label) {
            this.label = label;
            this.edges = new ArrayList<>();
        }

        public void addEdge(Node toNode, int weight) {
            Edge edge = new Edge(this, toNode, weight);
            edges.add(edge);
        }

        public List<Edge> getEdges() {
            return this.edges;
        }

        @Override
        public String toString() {
            return label;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            Node other = (Node) obj;
            return this.label.equals(other.label);
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

    public void addNode(String label) {
        Node newNode = new Node(label);
        nodes.putIfAbsent(label, newNode);
    }

    public void addEdge(String fromNodeLabel, String toNodeLabel, int weight) {
        Node fromNode = nodes.get(fromNodeLabel);
        Node toNode = nodes.get(toNodeLabel);

        if (fromNode == null || toNode == null) {
            throw new IllegalArgumentException("Node does not exist");
        }
        
        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public void print() {
        for (Node node : nodes.values()) {
            for (Edge edge : node.getEdges()) {
                System.out.println(edge);                
            }                        
        }
    }

    public void dijkstra(String fromNodeLabel) {
        Node fromNode = nodes.get(fromNodeLabel);
        if (fromNode == null)
            throw new IllegalArgumentException();
        class Entry {
            Node toNode;
            int distance;

            public Entry(Node toNode, int distance) {
                this.toNode = toNode;
                this.distance = distance;
            }

            public Node getNode() {
                return toNode;
            }

            public Integer getDistance() {
                return distance;
            }
        }
        
        Set<Node> visited = new HashSet<>();
        Map<Node, Integer> distances = new HashMap<>(); // <toNode, distance>
        Map<Node, Node> prevNodes = new HashMap<>(); // <toNode, throughNode>

        // init distances
        for (Node node : nodes.values()) {
            if (node.equals(fromNode)) {
                distances.put(node, 0);
            } else {
                distances.put(node, Integer.MAX_VALUE);
            }
        }
        Node currentNode = fromNode;
        while (true) {
            visited.add(currentNode);
            PriorityQueue<Entry> queue = new PriorityQueue<>(
                Comparator.comparingInt(Entry::getDistance)
            );
            for (Edge edge : currentNode.getEdges()) {
                Node neighbor = edge.toNode;
                if (visited.contains(neighbor))
                    continue;
                int directDistanceFromCurrentToNeighbor = edge.weight;
                int shortestPathToCurrent = distances.get(currentNode);
                int shortestPathToNeighbor = distances.get(neighbor);
                int shortestCandidate = shortestPathToCurrent + directDistanceFromCurrentToNeighbor;
                if (shortestCandidate < shortestPathToNeighbor) {
                    distances.put(neighbor, shortestCandidate);
                    prevNodes.put(neighbor, currentNode);
                }
                queue.add(new Entry(neighbor, distances.get(neighbor)));
            }
            if (queue.size() == 0)
                break;
            currentNode = queue.poll().getNode();
            queue.clear();
        }

        // result
        for (Node node : distances.keySet()) {
            System.out.println(fromNode + " -> " + node + " = " + distances.get(node));
        }
    }

    public boolean hasCycle() {
        Set<Node> visited = new HashSet<>();
        Set<Node> visiting = new HashSet<>();
        // loop all nodes
        for (Node node : nodes.values()) {
            if (visited.contains(node))
                continue;
            if (hasCycle(node, visiting, visited, null))
                return true;
        }
        // next node should not be parent
        // mark visited as pop out
        return false;
    }
        
    private boolean hasCycle(Node node, Set<Node> visiting, Set<Node> visited, Node parent) {
        // save to visiting
        visiting.add(node);
        // traverse DFS:
        for (Edge edge : node.getEdges()) {
            Node neighborNode = edge.toNode;
            // case 1: visited
            // case 3: parent
            if (neighborNode.equals(parent) || visited.contains(neighborNode))
                continue;
            // case 2: visiting
            if (visiting.contains(neighborNode))
                return true;
            
            if (hasCycle(neighborNode, visiting, visited, node))
                return true;
        }
        visited.add(node);
        visiting.remove(node);

        return false;
    }
}   
