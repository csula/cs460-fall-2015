package edu.csula.cs460.file;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.Lists;

public class ListFileTest {
    @Test
    public void testList1() {
        ListFile listFile = new ListFile("exercise-1/list-1.txt");

        assertEquals(
            "Test case 1 - `Testing getting list for [a]`",
            Lists.newArrayList("b", "c"),
            listFile.getList("a")
        );

        assertEquals(
            "Test case 2 - `Testing getting list for [c]`",
            Lists.newArrayList("a"),
            listFile.getList("c")
        );
    }

    @Test
    public void testList2() {
        ListFile listFile = new ListFile("exercise-1/list-2.txt");

        assertEquals(
            "Test case 3 - `Testing getting list for [b]`",
            Lists.newArrayList("d"),
            listFile.getList("b")
        );

        assertEquals(
            "Test case 4 - `Testing getting list for [d]`",
            Lists.newArrayList("c"),
            listFile.getList("d")
        );
    }
}
