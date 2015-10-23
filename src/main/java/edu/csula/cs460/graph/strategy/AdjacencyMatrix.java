package edu.csula.cs460.graph.strategy;

import edu.csula.cs460.graph.Edge;
import edu.csula.cs460.graph.Node;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

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
            if (adjacencyMatrix[x.getId()][i] != 0)
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
        ArrayList<Node> tempNodes = new ArrayList<Node>(Arrays.asList(nodes));
        tempNodes.add(x);
        nodes = new Node[tempNodes.size()];
        nodes = tempNodes.toArray(nodes);
        if (x.getId() > adjacencyMatrix.length) {
            int[][] tempArray = new int[x.getId()][x.getId()];
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                for (int j = 0; j < adjacencyMatrix.length; j++) {
                    tempArray[i][j] = adjacencyMatrix[i][j];
                }
            }
            adjacencyMatrix = tempArray;
        }
        return true;
    }

    @Override
    public boolean removeNode(Node x) {
        for (int i=0; i<nodes.length; i++) {
            if (x.getId() == nodes[i].getId()) {
                for (int j = 0; j<adjacencyMatrix.length; j++) {
                    adjacencyMatrix[x.getId()][j] = 0;
                }
                for (int k =0; k<adjacencyMatrix.length; k++) {
                    adjacencyMatrix[k][x.getId()] = 0;
                }
                ArrayList<Node> tempNodes = new ArrayList<Node>(Arrays.asList(nodes));
                tempNodes.remove(x);
                nodes = new Node[tempNodes.size()];
                nodes = tempNodes.toArray(nodes);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addEdge(Edge x) {
        if (adjacencyMatrix[x.getFrom().getId()][x.getTo().getId()] != 0) {
            return false;
        }
        else {
            adjacencyMatrix[x.getFrom().getId()][x.getTo().getId()] = x.getValue();
            return true;
        }
    }

    @Override
    public boolean removeEdge(Edge x) {
        if (adjacencyMatrix[x.getFrom().getId()][x.getTo().getId()] == 0) {
            return false;
        }
        else {
            adjacencyMatrix[x.getFrom().getId()][x.getTo().getId()] = 0;
            return true;
        }
    }
}
