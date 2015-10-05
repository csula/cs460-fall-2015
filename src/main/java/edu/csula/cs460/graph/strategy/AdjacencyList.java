package edu.csula.cs460.graph.strategy;

import edu.csula.cs460.graph.Node;

import java.io.File;
import java.util.List;
import java.util.Map;

public class AdjacencyList implements Representation {
    private Map<Node, List<Node>> adjacencyList;

    protected AdjacencyList(File file) {
        // TODO: read file and parse it into adjacencyList variable
    }

    @Override
    public boolean adjacent(Node x, Node y) {
        return false;
    }

    @Override
    public List<Node> neighbors(Node x) {
        return null;
    }

    @Override
    public boolean addNode(Node x) {
        return false;
    }

    @Override
    public boolean removeNode(Node x) {
        return false;
    }

    @Override
    public boolean addEdge(Node x) {
        return false;
    }

    @Override
    public boolean removeEdge(Node x) {
        return false;
    }
}
