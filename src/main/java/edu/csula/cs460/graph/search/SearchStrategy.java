package edu.csula.cs460.graph.search;

import edu.csula.cs460.graph.Edge;
import edu.csula.cs460.graph.Graph;
import edu.csula.cs460.graph.Node;

import java.util.List;

public interface SearchStrategy {
    public List<Edge> search(Graph graph, Node source, Node dist);
}
