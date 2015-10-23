package edu.csula.cs460.graph.strategy;

import edu.csula.cs460.graph.Node;
import edu.csula.cs460.graph.Edge;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;

public class AdjacencyList implements Representation {
    private Map<Node, List<Node>> adjacencyList;
    private int size;

    protected AdjacencyList(File file) {
        // TODO: read file and parse it into adjacencyList variable
        try {
            Scanner sc = new Scanner(file);
            int mapSize = sc.nextInt();
            adjacencyList = new HashMap<Node, List<Node>>();
            for (int i=0; i<mapSize; i++) {
                Node tempNode = new Node(i);
                adjacencyList.put(tempNode, new ArrayList<Node>());
            }
            sc.nextLine();
            while (sc.hasNext()) {
                String[] tempStringArray = sc.nextLine().split(":");
                int fromNode = Integer.parseInt(tempStringArray[0]);
                int toNode = Integer.parseInt(tempStringArray[1]);
                int weight = Integer.parseInt(tempStringArray[2]);
                adjacencyList.get(new Node(fromNode)).add(new Node(toNode));
            }
            sc.close();
        } catch (IOException e) {
            System.err.println("There is an error reading the file.");
            e.printStackTrace();
        }
    }
    @Override
    public boolean adjacent(Node x, Node y) {
        if(adjacencyList.get(x).contains(y) || adjacencyList.get(y).contains(x)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<Node> neighbors(Node x) {
        return adjacencyList.get(x);
    }

    @Override
    public boolean addNode(Node x) {
        if (adjacencyList.containsKey(x)) {
            return false;
        }
        else {
            adjacencyList.put(x, new ArrayList<Node>());
            return true;
        }
    }

    @Override
    public boolean removeNode(Node x) {
        if (!adjacencyList.containsKey(x))
            return false;
        else {
            for (int i=0; i<adjacencyList.size(); i++) {
                if (adjacencyList.get(new Node(i)).contains(x)) {
                    adjacencyList.get(new Node(i)).remove(x);
                }
            }
            adjacencyList.remove(x);
            return true;
        }
    }

    @Override
    public boolean addEdge(Edge x) {
        Node a = x.getFrom();
        Node b = x.getTo();
        if (adjacencyList.get(a).contains(b)) {
            return false;
        }
        else {
            adjacencyList.get(a).add(b);
            return true;
        }
    }

    @Override
    public boolean removeEdge(Edge x) {
        Node a = x.getFrom();
        Node b = x.getTo();
        if (!adjacencyList.get(a).contains(b)) {
            return false;
        }
        else {
            adjacencyList.get(a).remove(b);
            return true;
        }
    }
}
