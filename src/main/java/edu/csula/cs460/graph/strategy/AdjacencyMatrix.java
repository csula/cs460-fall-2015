package edu.csula.cs460.graph.strategy;

import edu.csula.cs460.graph.Edge;
import edu.csula.cs460.graph.Node;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AdjacencyMatrix implements Representation {
    private Node[] nodes;
    private int[][] adjacencyMatrix;

    protected AdjacencyMatrix(File file) {
        // TODO: read file and parse the file content into adjacencyMatrix
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {

            }
            sc.close();
        } catch (IOException e) {
            System.err.println("There is an error reading the file.");
            e.printStackTrace();
        }
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
    public boolean addEdge(Edge x) {
        return false;
    }

    @Override
    public boolean removeEdge(Edge x) {
        return false;
    }
}
