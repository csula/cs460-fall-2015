package edu.csula.cs460.graph.strategy;

import edu.csula.cs460.graph.Edge;
import edu.csula.cs460.graph.Node;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class AdjacencyMatrix implements Representation {
    private Node[] nodes;
    private int[][] adjacencyMatrix;


    protected AdjacencyMatrix(File file) {
        // TODO: read file and parse the file content into adjacencyMatrix
        try {
            Scanner sc = new Scanner(file);
            int matrixSize = sc.nextInt();
            adjacencyMatrix = new int[matrixSize][matrixSize];
            nodes = new Node[matrixSize];
            sc.nextLine();
            for(int i = 0; i < matrixSize; i++) {
                nodes[i] = new Node(i);
            }
            while (sc.hasNext()) {
                String[] tempStringArray = sc.nextLine().split(":");
                int row = Integer.parseInt(tempStringArray[0]);
                int column = Integer.parseInt(tempStringArray[1]);
                int weight = Integer.parseInt(tempStringArray[2]);
                adjacencyMatrix[row][column] = weight;
            }
            sc.close();
        } catch (IOException e) {
            System.err.println("There is an error reading the file.");
            e.printStackTrace();
        }
    }

    @Override
    public boolean adjacent(Node x, Node y) {
        if(adjacencyMatrix[x.getId()][y.getId()] != 0 || adjacencyMatrix[y.getId()][x.getId()] != 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<Node> neighbors(Node x) {
        List<Node> neighbors = new ArrayList<Node>();
        for (int i=0; i<nodes.length; i++){
            if (adjacent(x, nodes[i]))
                neighbors.add(nodes[i]);
        }
        return neighbors;
    }

    @Override
    public boolean addNode(Node x) {
        for (int i=0; i<nodes.length; i++) {
            if (x.equals(nodes[i])) {
                return false;
            }
        }
        int nodePos = x.getId();
        return true;
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
