package edu.csula.cs460.game;

import com.google.common.collect.Lists;
import edu.csula.cs460.graph.Edge;
import edu.csula.cs460.graph.Graph;
import edu.csula.cs460.graph.Node;
import edu.csula.cs460.graph.strategy.Representation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimaxTest {
    private Graph graph = new Graph(Representation.of(Representation.STRATEGY.OBJECT_ORIENTED));

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 8; i ++) {
            graph.addNode(new Node<>(i, 0));
        }
        graph.addNode(new Node<>(7, -10));
        graph.addNode(new Node<>(8, 8));
        graph.addNode(new Node<>(9, 9));
        graph.addNode(new Node<>(10, 15));
        graph.addNode(new Node<>(11, 6));
        graph.addNode(new Node<>(12, 100));
        graph.addNode(new Node<>(13, -15));
        graph.addNode(new Node<>(14, -9));

        graph.addEdge(new Edge(new Node<>(0, 0), new Node<>(1, 0), 1));
        graph.addEdge(new Edge(new Node<>(0, 0), new Node<>(2, 0), 1));
        graph.addEdge(new Edge(new Node<>(1, 0), new Node<>(3, 0), 1));
        graph.addEdge(new Edge(new Node<>(1, 0), new Node<>(4, 0), 1));
        graph.addEdge(new Edge(new Node<>(2, 0), new Node<>(5, 0), 1));
        graph.addEdge(new Edge(new Node<>(2, 0), new Node<>(6, 0), 1));
        graph.addEdge(new Edge(new Node<>(3, 0), new Node<>(7, -10), 1));
        graph.addEdge(new Edge(new Node<>(3, 0), new Node<>(8, 8), 1));
        graph.addEdge(new Edge(new Node<>(4, 0), new Node<>(9, 9), 1));
        graph.addEdge(new Edge(new Node<>(4, 0), new Node<>(10, 15), 1));
        graph.addEdge(new Edge(new Node<>(5, 0), new Node<>(11, 6), 1));
        graph.addEdge(new Edge(new Node<>(5, 0), new Node<>(12, 100), 1));
        graph.addEdge(new Edge(new Node<>(6, 0), new Node<>(13, -15), 1));
        graph.addEdge(new Edge(new Node<>(6, 0), new Node<>(14, -9), 1));
    }

    @Test
    public void sanityCheck() {
        // just to check if my sanity is still here within the power of OOP
        assertTrue(graph.adjacent(new Node<>(0, 0), new Node<>(1, 0)));
        assertFalse(graph.adjacent(new Node<>(1, 0), new Node<>(9, 0)));

        assertEquals(
            Lists.newArrayList(new Node<>(1, 0), new Node<>(2, 0)),
            graph.neighbors(new Node<>(0, 0))
        );

        assertEquals(new Node<>(0, 0), graph.getNode(0).get());
    }

    @Test
    public void testGetBestMove() {
        assertEquals(
            new Node<>(2, -9),
            Minimax.getBestMove(graph, new Node<>(0, 0), 3, true)
        );

        // test after minimax mutate effect
        assertEquals(
            new Node<>(0, 8),
            graph.getNode(0).get()
        );
        assertEquals(
            new Node<>(1, 8),
            graph.getNode(1).get()
        );
        assertEquals(
            new Node<>(2, -9),
            graph.getNode(2).get()
        );
        assertEquals(
            new Node<>(3, 8),
            graph.getNode(3).get()
        );
        assertEquals(
            new Node<>(4, 15),
            graph.getNode(4).get()
        );
        assertEquals(
            new Node<>(5, 100),
            graph.getNode(5).get()
        );
        assertEquals(
            new Node<>(6, -9),
            graph.getNode(6).get()
        );
    }
}