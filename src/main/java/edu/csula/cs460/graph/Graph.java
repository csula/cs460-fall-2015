package edu.csula.cs460.graph;

import edu.csula.cs460.graph.strategy.Representation;

import java.util.List;

public class Graph {
    private final Representation strategy;

    public Graph(Representation strategy) {
        this.strategy = strategy;
    }

    public boolean adjacent(Node x, Node y) {
        return strategy.adjacent(x, y);
    }

    public List<Node> neighbors(Node x) {
        return strategy.neighbors(x);
    }

    public boolean addNode(Node x) {
        return strategy.addNode(x);
    }

    public boolean removeNode(Node x) {
        return strategy.removeNode(x);
    }

    public boolean addEdge(Node x) {
        return strategy.addEdge(x);
    }

    public boolean removeEdge(Node x) {
        return strategy.removeEdge(x);
    }
}
