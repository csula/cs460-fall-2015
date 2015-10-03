package edu.csula.cs460.file;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MatrixFile {
    private final int[][] matrix;

    public MatrixFile(String filepath) {
        // since we don't know how many rows there is going to be, we will
        // create a list to hold it instead
        List<int[]> dynamicMatrix = Lists.newArrayList();

        // use class loader to read file from `resources` folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filepath).getFile());

        try (Scanner in = new Scanner(file)) {
            while (in.hasNextLine()) {
                dynamicMatrix.add(
                    Arrays.stream(in.nextLine().split(" "))
                        .mapToInt(value -> Integer.parseInt(value))
                        .toArray()
                );
            }
        } catch (IOException e) {
            // in case of error, always log error!
            System.err.println("MatrixFile has trouble reading file");
            e.printStackTrace();
        }

        matrix = dynamicMatrix.stream().toArray(int[][]::new);
    }

    public int getValue(int row, int col) {
        return matrix[row][col];
    }

    public int getSum() {
        return Arrays.stream(matrix)
            .mapToInt(row -> Arrays.stream(row).sum())
            .sum();
    }
}
