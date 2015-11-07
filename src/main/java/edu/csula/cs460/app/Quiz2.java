package edu.csula.cs460.app;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import edu.csula.cs460.graph.Edge;
import edu.csula.cs460.graph.Graph;
import edu.csula.cs460.graph.Node;
import edu.csula.cs460.graph.search.BFS;
import edu.csula.cs460.graph.search.DFS;
import edu.csula.cs460.graph.search.SearchStrategy;
import edu.csula.cs460.graph.strategy.Representation;

/**
 * A simple main app for constructing answer for quiz-2
 */
public class Quiz2 {
    public static void main(String[] args) {
        Quiz2 quiz = new Quiz2();
        ClassLoader classLoader = quiz.getClass().getClassLoader();
        File quizFile = new File(classLoader.getResource("quiz-2/quiz-2-graph.txt").getFile());

        Graph quizAdjacencyMatrixGraph = new Graph(
            Representation.of(
                Representation.STRATEGY.ADJACENCY_MATRIX,
                quizFile
            )
        );
        Graph quizAdjacencyListGraph = new Graph(
            Representation.of(
                Representation.STRATEGY.ADJACENCY_LIST,
                quizFile
            )
        );

        System.out.println(quizAdjacencyMatrixGraph);

        printPathUsingStrategy(quizAdjacencyListGraph, new BFS(), new Node(1), new Node(12));
        printPathUsingStrategy(quizAdjacencyListGraph, new BFS(), new Node(1), new Node(7));
    }

    public static void printPathUsingStrategy (Graph graph, SearchStrategy search, Node fromNode, Node toNode) {
        List<Edge> result = graph.search(search, fromNode, toNode);

        System.out.println(
            String.format(
                "Searching using strategy %s from %s to %s",
                search,
                fromNode,
                toNode
            )
        );

        System.out.println(Joiner.on(",").join(result));
    }
}
