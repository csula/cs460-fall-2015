package edu.csula.cs460.file;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.io.File;
import java.io.IOException;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;

public class ListFile {
    // try to make *all* variables final as possible
    private final Map<String, List<String>> adjancencyList;

    public ListFile(String filepath) {
        // ListMultimap is a very useful class when it comes to Map of key
        // to a Collection of values
        ListMultimap<String, String> multimap = ArrayListMultimap.create();

        // use class loader to read file from `resources` folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filepath).getFile());

        // try with resources (auto closable)
        try (Scanner in = new Scanner(file)) {
            while (in.hasNextLine()) {
                // consider Java doesn't have destruct, we will need to
                // create a temp variable to hodl both key and values
                String[] parts = in.nextLine().split(":");
                // stream api power with lambda expression
                Arrays.stream(parts[1].split(" "))
                    .forEach(value -> multimap.put(parts[0], value));
            }
        } catch (IOException e) {
            // in case of error, always log error!
            System.err.println("ListFile has trouble reading file");
            e.printStackTrace();
        }

        adjancencyList = Multimaps.asMap(multimap);
    }

    public List<String> getList(String key) {
        return adjancencyList.get(key);
    }
}
