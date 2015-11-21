package edu.csula.cs460.graph.strategy;

import com.google.common.collect.Lists;
import edu.csula.cs460.graph.Edge;
import edu.csula.cs460.graph.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ObjectOriented implements Representation {
    private List<Node> nodes;
    private List<Edge> edges;

    protected ObjectOriented() {
        nodes = Lists.newArrayList();
        edges = Lists.newArrayList();
    }
    protected ObjectOriented(File file) {
        nodes = Lists.newArrayList();
        edges = Lists.newArrayList();

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

    @Override
    public boolean adjacent(Node x, Node y) {
        for (Edge edge: edges) {
            if (edge.getFrom().equals(x) && edge.getTo().equals(y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Node> neighbors(Node x) {
        List<Node> result = Lists.newArrayList();

        if (!nodes.contains(x)) {
            return result;
        }

        for (Edge edge: edges) {
            if (edge.getFrom().equals(x)) {
                result.add(edge.getTo());
            }
        }

        return result;
    }

    @Override
    public boolean addNode(Node x) {
        if (nodes.contains(x)) {
            return false;
        }

        nodes.add(x);
        return true;
    }

    @Override
    public boolean removeNode(Node x) {
        if (!nodes.contains(x)) {
            return false;
        }

        Iterator<Edge> iterator = edges.iterator();
        while (iterator.hasNext()) {
            Edge edge = iterator.next();
            if (edge.getTo().equals(x) || edge.getFrom().equals(x)) {
                iterator.remove();
            }
        }

        return nodes.remove(x);
    }

    @Override
    public boolean addEdge(Edge x) {
        if (!nodes.contains(x.getFrom())) {
            nodes.add(x.getFrom());
        }
        if (!nodes.contains(x.getTo())) {
            nodes.add(x.getTo());
        }

        if (edges.contains(x)) {
            return false;
        }

        edges.add(x);

        return true;
    }

    @Override
    public boolean removeEdge(Edge x) {
        return edges.remove(x);
    }

    @Override
    public Optional<Node> getNode(int index) {
        for (Node node: nodes) {
            if (node.getId() == index) {
                return Optional.of(node);
            }
        }
        return Optional.empty();
    }

    @Override
    public int distance(Node from, Node to) {
        for (Edge edge: edges) {
            if (edge.getFrom().equals(from) && edge.getTo().equals(to)) {
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
