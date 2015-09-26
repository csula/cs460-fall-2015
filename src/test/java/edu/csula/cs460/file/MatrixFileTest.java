package edu.csula.cs460.file;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class MatrixFileTest {
    @Test
    public void test2DArray1() {
        MatrixFile matrixFile = new MatrixFile("exercise-1/2d-array-1.txt");

        assertEquals(
            "Text case 1 - `test row 0 col 0`",
            1,
            matrixFile.getValue(0, 0)
        );

        assertEquals(
            "Text case 2 - `test row 4 col 5`",
            1,
            matrixFile.getValue(4, 5)
        );

        assertEquals(
            "Text case 3 - `test row 4 col 5`",
            1,
            matrixFile.getValue(4, 5)
        );

        assertEquals(
            "Text case 4 - `test sum`",
            64,
            matrixFile.getSum()
        );
    }

    @Test
    public void test2DArray2() {
        MatrixFile matrixFile = new MatrixFile("exercise-1/2d-array-2.txt");

        assertEquals(
            "Text case 5 - `test row 0 col 0`",
            1,
            matrixFile.getValue(0, 0)
        );

        assertEquals(
            "Text case 6 - `test row 4 col 5`",
            1,
            matrixFile.getValue(4, 5)
        );

        assertEquals(
            "Text case 7 - `test row 4 col 5`",
            3,
            matrixFile.getValue(4, 5)
        );

        assertEquals(
            "Text case 8 - `test sum`",
            197,
            matrixFile.getSum()
        );
    }
}
