package edu.csula.cs460.graph.search;

import com.google.common.base.Stopwatch;
import edu.csula.cs460.graph.Graph;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertEquals;

public class AStarTest {
    private Stopwatch timer;
    private ClassLoader classLoader;

    @Test
    // a dummy test to warm up JVM machine about variables we use
    public void warmup() {
        File file1 = new File(classLoader.getResource("homework-3/grid-1.txt").getFile());
        File file2 = new File(classLoader.getResource("homework-3/grid-2.txt").getFile());
        File file3 = new File(classLoader.getResource("homework-3/grid-3.txt").getFile());
        File file4 = new File(classLoader.getResource("homework-3/grid-4.txt").getFile());
        File file5 = new File(classLoader.getResource("homework-3/grid-5.txt").getFile());

        new AStar().searchFromGridFile(file1);
        new AStar().searchFromGridFile(file2);
        new AStar().searchFromGridFile(file3);
        new AStar().searchFromGridFile(file4);
        new AStar().searchFromGridFile(file5);
    }

    @Before
    public void setUp() {
        classLoader = getClass().getClassLoader();
        timer = Stopwatch.createStarted();
    }

    @Test(timeout=15)
    public void testAStar1() {
        File file = new File(classLoader.getResource("homework-3/grid-1.txt").getFile());

        String result = new AStar().searchFromGridFile(file);

        System.out.println("A star 1 spends " + timer.stop());

        assertEquals(
            "Test grid 1 from key point to key point",
            "SSSSE",
            result
        );
    }

    @Test(timeout=15)
    public void testAStar2() {
        File file = new File(classLoader.getResource("homework-3/grid-2.txt").getFile());

        String result = new AStar().searchFromGridFile(file);

        System.out.println("A star 2 spends " + timer.stop());

        assertEquals(
            "Test grid 2 from key point to key point",
            "SSSSEEEEEEEEEEEEENNWNWNW",
            result
        );
    }

    @Test(timeout=15)
    public void testAStar3() {
        File file = new File(classLoader.getResource("homework-3/grid-3.txt").getFile());

        String result = new AStar().searchFromGridFile(file);

        System.out.println("A star 3 spends " + timer.stop());

        assertEquals(
            "Test grid 3 from key point to key point",
            "SSSSEESESSWWWW",
            result
        );
    }

    @Test(timeout=200)
    public void testAStar4() {
        File file = new File(classLoader.getResource("homework-3/grid-4.txt").getFile());
        String expectedOutput = "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSESE";

        String result = new AStar().searchFromGridFile(file);

        System.out.println("A star 4 spends " + timer.stop());

        assertEquals(
            "Test grid 4 number of S",
            findNumberOfCharacter(expectedOutput, "([S])"),
            findNumberOfCharacter(result, "([S])")
        );

        assertEquals(
            "Test grid 4 number of E",
            findNumberOfCharacter(expectedOutput, "([E])"),
            findNumberOfCharacter(result, "([E])")
        );
    }

    @Test
    public void testAStar5() {
        File file = new File(classLoader.getResource("homework-3/grid-5.txt").getFile());

        String expectedOutput = "SSSSSSSSSSEESSEESESESSEESSEESESESESESSEESESESESESESSESEESESESSESEESSEESSEESESESESESSESEESSESESEESSESEESESSESEESESESESESSEESESESESESESESESESSEESESESESESESSEESSEESESSESEESSEESESSEESESESESESESSEESESESSEESESSESEESSEESESESESSEESSESEESESSESESESESEESSEESESESESESESESESESESESESESESESSEESESSEESSEESESESESSEESESESSEESESESSEESESESESESESESESESESESESESSESEESSEESESSEESESSEESSEESESSEESESESESESESESESESESSEESEEEESSSSSE";

        String result = new AStar().searchFromGridFile(file);

        System.out.println("A star 5 spends " + timer.stop());

        assertEquals(
            "Test grid 5 number of S",
            findNumberOfCharacter(expectedOutput, "([S])"),
            findNumberOfCharacter(result, "([S])")
        );

        assertEquals(
            "Test grid 5 number of E",
            findNumberOfCharacter(expectedOutput, "([E])"),
            findNumberOfCharacter(result, "([E])")
        );
    }

    private int findNumberOfCharacter(String input, String regex) {
        Pattern pattern = Pattern.compile(regex); //case insensitive, use [g] for only lower
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) count++;

        return count;
    }
}
