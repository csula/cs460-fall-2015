package edu.csula.cs460.graph.strategy;

import com.google.common.collect.Lists;
import edu.csula.cs460.graph.Node;
import edu.csula.cs460.graph.Edge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AdjacencyList implements Representation {
    private Map<Node, List<Edge>> adjacencyList;

    protected AdjacencyList() {
        adjacencyList = new HashMap<>();
    }
    protected AdjacencyList(File file) {
        adjacencyList = new HashMap<>();

        try {
            Scanner in = new Scanner(file);

            // to skip the first line
            in.nextLine();

            // reading edges line by line
            while (in.hasNextLine()) {
                String line = in.nextLine();
                int[] parts = Arrays.stream(
                    line.split(":")
                ).mapToInt(Integer::parseInt)
                    .toArray();
                Edge edge = new Edge(
                    new Node(parts[0]),
                    new Node(parts[1]),
                    parts[2]
                );

                addEdge(edge);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void debugPrint() {
        for (Map.Entry<Node, List<Edge>> entry : adjacencyList.entrySet()) {
            String result = entry.getKey().toString() + ":";

            for (Edge edge: entry.getValue()) {
                result += edge.toString() + ",";
            }

            System.out.println(result);
        }
    }

    private boolean containNode(Node node) {
        // FIXME: maybe there is better way to check if node exists
        // to check if the node lives in any edge values
        for (Map.Entry<Node, List<Edge>> entry : adjacencyList.entrySet()) {
            for (Edge edge: entry.getValue()) {
                if (edge.getTo().equals(node)) {
                    return true;
                }
            }
        }

        // to check node exists as key
        if (adjacencyList.containsKey((node))) {
            return true;
        }

        return false;
    }

    @Override
    public boolean adjacent(Node x, Node y) {
        boolean result = false;

        for (Edge edge: adjacencyList.get(x)) {
            result = result || edge.getTo().equals(y);
        }

        return result;
    }

    @Override
    public List<Node> neighbors(Node x) {
        if (!adjacencyList.containsKey(x)) {
            return new ArrayList<>();
        }

        List<Node> result = Lists.newArrayList();

        for (Edge edge: adjacencyList.get(x)) {
            result.add(edge.getTo());
        }

        return result;
    }

    @Override
    public boolean addNode(Node x) {
        if (containNode(x)) {
            return false;
        }

        adjacencyList.put(x, Lists.newArrayList());

        return true;
    }

    @Override
    public boolean removeNode(Node x) {
        if (!containNode(x)) {
            return false;
        }

        // remove node as key
        adjacencyList.remove(x);

        // remove node from any edge that contains this node
        for (Map.Entry<Node, List<Edge>> entry : adjacencyList.entrySet()) {
            for (Edge edge: entry.getValue()) {
                if (edge.getTo().equals(x)) {
                    List<Edge> copyList = new ArrayList<>(entry.getValue());
                    copyList.remove(edge);
                    adjacencyList.replace(entry.getKey(), copyList);
                }
            }
        }

        return true;
    }

    @Override
    public boolean addEdge(Edge x) {
        // fromNode, toNode, edgeValue
        if (adjacencyList.containsKey(x.getFrom())) {
            if (adjacencyList.get(x.getFrom()).contains(x)) {
                return false;
            }

            adjacencyList.get(x.getFrom()).add(x);
        } else {
            adjacencyList.put(x.getFrom(), Lists.newArrayList(x));
        }

        return true;
    }

    @Override
    public boolean removeEdge(Edge x) {
        return adjacencyList.get(x.getFrom())
            .remove(x);
    }

    @Override
    public int distance(Node from, Node to) {
        if (!adjacencyList.containsKey(from)) {
            return 0;
        }

        for (Edge edge: adjacencyList.get(from)) {
            if (edge.getTo().equals(to)) {
                return edge.getValue();
            }
        }

        return 0;
    }

    @Override
    public String toString() {
        return "";
    }
}
