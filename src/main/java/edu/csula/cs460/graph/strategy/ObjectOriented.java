package edu.csula.cs460.graph.strategy;

import edu.csula.cs460.graph.Edge;
import edu.csula.cs460.graph.Node;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class ObjectOriented implements Representation {
    private List<Node> nodes;
    private List<Edge> edges;

    protected ObjectOriented(File file) {
        // TODO: parse file content and add it to nodes
        try {
            Scanner sc = new Scanner(file);
            nodes = new ArrayList<Node>();
            edges = new ArrayList<Edge>();
            int temp = sc.nextInt();
            for (int i=0; i<temp; i++) {
                nodes.add(new Node(i));
            }
            sc.nextLine();
            while (sc.hasNext()) {
                String[] tempStringArray = sc.nextLine().split(":");
                int fromNode = Integer.parseInt(tempStringArray[0]);
                int toNode = Integer.parseInt(tempStringArray[1]);
                int weight = Integer.parseInt(tempStringArray[2]);
                edges.add(new Edge(new Node(fromNode), new Node(toNode), weight));
            }
            sc.close();
        } catch (IOException e) {
            System.err.println("There is an error reading the file.");
            e.printStackTrace();
        }
    }

    @Override
    public boolean adjacent(Node x, Node y) {
        for (int i=0; i<edges.size(); i++) {
            if ((edges.get(i).getFrom().getId() == x.getId() && edges.get(i).getTo().getId() == y.getId()) ||
                    (edges.get(i).getFrom().getId() == y.getId() && edges.get(i).getTo().getId() == x.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Node> neighbors(Node x) {
        ArrayList<Node> tempNeighbors = new ArrayList<Node>();
        for (int i=0; i<edges.size(); i++) {
            if (edges.get(i).getFrom().getId() == x.getId()) {
                tempNeighbors.add(edges.get(i).getTo());
            }
        }
        return tempNeighbors;
    }

    @Override
    public boolean addNode(Node x) {
        if (nodes.contains(x))
            return false;
        else {
            nodes.add(x);
            return true;
        }
    }

    @Override
    public boolean removeNode(Node x) {
        if (!nodes.contains(x)) {
            return false;
        }
        else {
            nodes.remove(x);
            for (int i=0; i<edges.size(); i++) {
                if (edges.get(i).getFrom().getId() == x.getId() || edges.get(i).getTo().getId() == x.getId()) {
                    edges.remove(i);
                }
            }
            return true;
        }
    }

    @Override
    public boolean addEdge(Edge x) {
        if (edges.contains(x)) {
            return false;
        }
        else {
            edges.add(x);
            return true;
        }
    }

    @Override
    public boolean removeEdge(Edge x) {
        if (!edges.contains(x)) {
            return false;
        }
        else {
            edges.remove(x);
            return true;
        }
    }
}
