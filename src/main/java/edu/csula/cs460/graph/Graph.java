package edu.csula.cs460.graph;

import edu.csula.cs460.graph.strategy.Representation;

import java.util.List;

public class Graph {
    private final Representation strategy;

    public Graph(Representation strategy) {
        this.strategy = strategy;
    }

    /**
     * Return true if node x is connecting to y false otherwise
     */
    public boolean adjacent(Node x, Node y) {
        return strategy.adjacent(x, y);
    }

    /**
     * Return all neighbor nodes (that has at least one edge connected from node x)
     */
    public List<Node> neighbors(Node x) {
        return strategy.neighbors(x);
    }

    /**
     * Add a node to graph
     *
     * Return false if node is already in graph, true if node is added to graph
     * successfully
     */
    public boolean addNode(Node x) {
        return strategy.addNode(x);
    }

    /**
     * Remove a node to graph (note that you also need to remove edge if there
     * is any edge connecting to/from this node)
     *
     * Return true if the node is removed successfully, false if the node
     * doesn't exist in graph
     */
    public boolean removeNode(Node x) {
        return strategy.removeNode(x);
    }

    /**
     * Add an edge to graph (connecting two nodes)
     *
     * Return true if the edge is added successfully, return false if the edge
     * already exists in graph
     */
    public boolean addEdge(Edge x) {
        return strategy.addEdge(x);
    }

    /**
     * Remove an edge from graph (remember not to remove node)
     *
     * Return true if edge is removed successfully, return false if the edge is
     * not presented in graph
     */
    public boolean removeEdge(Edge x) {
        return strategy.removeEdge(x);
    }
}
