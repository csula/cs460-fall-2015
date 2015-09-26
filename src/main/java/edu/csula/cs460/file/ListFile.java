package edu.csula.cs460.file;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import com.google.common.collect.Lists;

public class ListFile {
    private Map<String, List<String>> adjancencyList;

    public ListFile(String filepath) {
        // TODO: read file from filepath ('exercise-1/list-1.txt' for
        // example) and parse line by line to fill out adjancencyList
    }

    public List<String> getList(String key) {
        // TODO: get List of String for specific key
        return Lists.newArrayList();
    }
}
