package edu.csula.cs460.game;

import edu.csula.cs460.graph.Edge;
import edu.csula.cs460.graph.Graph;
import edu.csula.cs460.graph.Node;
import edu.csula.cs460.graph.strategy.Representation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlphaBetaTest {
    private Graph graph = new Graph(Representation.of(Representation.STRATEGY.OBJECT_ORIENTED));

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 15; i ++) {
            graph.addNode(new Node<>(i, 0));
        }
        graph.addNode(new Node<>(15, 8));
        graph.addNode(new Node<>(16, -8));
        graph.addNode(new Node<>(17, 4));
        graph.addNode(new Node<>(18, -9));
        graph.addNode(new Node<>(19, -15));
        graph.addNode(new Node<>(20, 9));
        graph.addNode(new Node<>(21, -9));
        graph.addNode(new Node<>(22, -13));
        graph.addNode(new Node<>(23, -14));
        graph.addNode(new Node<>(24, -16));
        graph.addNode(new Node<>(25, -14));
        graph.addNode(new Node<>(26, -15));
        graph.addNode(new Node<>(27, 9));
        graph.addNode(new Node<>(28, 3));
        graph.addNode(new Node<>(29, 6));
        graph.addNode(new Node<>(30, 14));

        int diff = 1;
        for (int i = 0; i < 7; i ++ ) {
            graph.addEdge(new Edge(new Node<>(i, 0), new Node<>(i+diff, 0), 1));
            diff ++;
            graph.addEdge(new Edge(new Node<>(i, 0), new Node<>(i+diff, 0), 1));
        }

        graph.addEdge(new Edge(new Node<>(7, 0), new Node<>(15, 8), 1));
        graph.addEdge(new Edge(new Node<>(7, 0), new Node<>(16, -8), 1));
        graph.addEdge(new Edge(new Node<>(8, 0), new Node<>(17, 4), 1));
        graph.addEdge(new Edge(new Node<>(8, 0), new Node<>(18, -9), 1));
        graph.addEdge(new Edge(new Node<>(9, 0), new Node<>(19, -15), 1));
        graph.addEdge(new Edge(new Node<>(9, 0), new Node<>(20, 9), 1));
        graph.addEdge(new Edge(new Node<>(10, 0), new Node<>(21, -9), 1));
        graph.addEdge(new Edge(new Node<>(10, 0), new Node<>(22, -13), 1));
        graph.addEdge(new Edge(new Node<>(11, 0), new Node<>(23, -14), 1));
        graph.addEdge(new Edge(new Node<>(11, 0), new Node<>(24, -16), 1));
        graph.addEdge(new Edge(new Node<>(12, 0), new Node<>(25, -14), 1));
        graph.addEdge(new Edge(new Node<>(12, 0), new Node<>(26, -15), 1));
        graph.addEdge(new Edge(new Node<>(13, 0), new Node<>(27, 9), 1));
        graph.addEdge(new Edge(new Node<>(13, 0), new Node<>(28, 3), 1));
        graph.addEdge(new Edge(new Node<>(14, 0), new Node<>(29, 6), 1));
        graph.addEdge(new Edge(new Node<>(14, 0), new Node<>(30, 14), 1));
    }

    @Test
    public void sanityCheck() {
        assertEquals(new Node<>(15, 8), graph.getNode(15).get());
        assertEquals(new Node<>(29, 6), graph.getNode(29).get());
    }

    @Test
    public void testGetBestMove() throws Exception {
        assertEquals(
            new Node<>(1, -13),
            AlphaBeta.getBestMove(graph, new Node<>(0, 0), 4, Integer.MIN_VALUE, Integer.MAX_VALUE, true)
        );

        // check after effect
        assertEquals(
            new Node<>(3, -8),
            graph.getNode(3).get()
        );
        assertEquals(
            new Node<>(1, -13),
            graph.getNode(1).get()
        );
        assertEquals(
            new Node<>(2, -14),
            graph.getNode(2).get()
        );
        assertEquals(
            new Node<>(5, -14),
            graph.getNode(5).get()
        );
        assertEquals(
            new Node<>(9, -15),
            graph.getNode(9).get()
        );
        assertEquals(
            new Node<>(6, 0),
            graph.getNode(6).get()
        );
        assertEquals(
            new Node<>(13, 0),
            graph.getNode(13).get()
        );
    }
}
