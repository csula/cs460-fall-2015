package edu.csula.cs460.graph.strategy;

import edu.csula.cs460.graph.Edge;
import edu.csula.cs460.graph.Node;

import java.io.File;
import java.util.List;

public class ObjectOriented implements Representation {
    private List<Node> nodes;
    private List<Edge> edges;

    protected ObjectOriented(File file) {
        // TODO: parse file content and add it to nodes
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
