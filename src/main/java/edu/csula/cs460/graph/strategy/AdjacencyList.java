package edu.csula.cs460.graph.strategy;

import edu.csula.cs460.graph.Node;
import edu.csula.cs460.graph.Edge;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;

public class AdjacencyList implements Representation {
    private Map<Node, List<Node>> adjacencyList;
    private int size;

    protected AdjacencyList(File file) {
        // TODO: read file and parse it into adjacencyList variable
        try {
            Scanner sc = new Scanner(file);
            int line = 0;
            while (sc.hasNext()) {
                if (line == 0) {
                }
                else {

                }
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
