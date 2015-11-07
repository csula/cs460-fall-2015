package edu.csula.cs460.graph.search;

import edu.csula.cs460.graph.Edge;
import edu.csula.cs460.graph.Graph;
import edu.csula.cs460.graph.Node;

import java.util.*;

public class BFS implements SearchStrategy {
    public List<Edge> search(Graph graph, Node source, Node dist) {
        List<Edge> result = new ArrayList<>();
        Map<Node, Node> parents = new HashMap<>();
        Map<Node, Integer> distances = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();

        distances.put(source, 0);
        parents.put(source, null);
        queue.add(source);

        while (!queue.isEmpty()) {
            Node u = queue.poll();

            // for all the neighbors (possible next moves)
            graph.neighbors(u).stream().filter(tile -> !distances.containsKey(tile)).forEach(tile -> {
                distances.put(tile, distances.get(u) + 1);
                parents.put(tile, u);
                queue.add(tile);
            });
        }

        Node currentNode = dist;

        // build the list of moves by recursively calling parent
        while (!currentNode.equals(source)) {
            Node parent = parents.get(currentNode);

            if (parent != null) {
                result.add(new Edge(parent, currentNode, graph.distance(parent, currentNode)));
            }

            currentNode = parents.get(currentNode);
        }

        Collections.reverse(result);

        return result;
    }
}
