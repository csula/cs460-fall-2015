package edu.csula.cs460.graph.search;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import edu.csula.cs460.graph.Edge;
import edu.csula.cs460.graph.Graph;
import edu.csula.cs460.graph.Node;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DFS implements SearchStrategy {
    public List<Edge> search(Graph graph, Node source, Node dist) {
        Map<Node, Node> parents = Maps.newLinkedHashMap();
        Map<Node, Integer> distances = Maps.newLinkedHashMap();
        List<Edge> result = Lists.newArrayList();

        parents.put(source, null);
        distances.put(source, 0);

        DFSHelper(graph, source, parents);

        Node currentNode = dist;

        while (currentNode != null) {
            Node parent = parents.get(currentNode);
            if (parent != null) {
                result.add(new Edge(parent, currentNode, graph.distance(parent, currentNode)));
            }
            currentNode = parent;
        }

        Collections.reverse(result);

        return result;
    }

    private void DFSHelper(
        Graph graph,
        Node source,
        Map<Node, Node> parents
    ) {
        // HACK hack hack ...
        List<Node> neighbors = graph.neighbors(source);
        Collections.reverse(neighbors);

        for (Node neighbor: neighbors) {
            parents.put(neighbor, source);
            DFSHelper(graph, neighbor, parents);
        }
    }
}
