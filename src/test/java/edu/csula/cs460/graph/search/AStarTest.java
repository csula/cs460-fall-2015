package edu.csula.cs460.graph.search;

import edu.csula.cs460.graph.Graph;
import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertEquals;

public class AStarTest {
    // used for bonus
    private Graph graph;

    @Test(timeout=1000)
    public void testAStar1() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("homework-3/grid-1.txt").getFile());

        String result = new AStar().searchFromGridFile(file);

        assertEquals(
            "Test grid 1 from key point to key point",
            "SSSSE",
            result
        );
    }

    @Test(timeout=1000)
    public void testAStar2() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("homework-3/grid-2.txt").getFile());

        String result = new AStar().searchFromGridFile(file);

        assertEquals(
            "Test grid 2 from key point to key point",
            "SSSSEEEEEEEEEEEEENNWNWWN",
            result
        );
    }

    @Test(timeout=1000)
    public void testAStar3() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("homework-3/grid-3.txt").getFile());

        String result = new AStar().searchFromGridFile(file);

        assertEquals(
            "Test grid 3 from key point to key point",
            "SSSSEESESSWWWW",
            result
        );
    }

    @Test(timeout=1000)
    public void testAStar4() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("homework-3/grid-4.txt").getFile());

        String result = new AStar().searchFromGridFile(file);

        assertEquals(
            "Test grid 4 from key point to key point",
            "SSSSEESESSWWWSSSSEESESS",
            result
        );
    }

    @Test(timeout=1000)
    public void testAStar5() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("homework-3/grid-5.txt").getFile());

        String result = new AStar().searchFromGridFile(file);

        assertEquals(
            "Test grid 5 from key point to key point",
            "SSSSEESESSWWWSSSSEESESSSWWWSSESEES",
            result
        );
    }
}
