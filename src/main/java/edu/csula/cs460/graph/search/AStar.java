package edu.csula.cs460.graph.search;

import edu.csula.cs460.graph.Edge;
import edu.csula.cs460.graph.Graph;
import edu.csula.cs460.graph.Node;

import java.io.File;
import java.util.List;

public class AStar implements SearchStrategy {
    @Override
    public List<Edge> search(Graph graph, Node source, Node dist) {
        return null;
    }

    /**
     * A lower level implementation to get path from key point to key point
     */
    public String searchFromGridFile(File file) {
        String result = "";

        // TODO: read file and generate path using AStar algorithm

        return result;
    }
}
