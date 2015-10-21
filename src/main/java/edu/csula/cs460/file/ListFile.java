package edu.csula.cs460.file;

import java.util.Arrays;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReferenceArray;

import com.google.common.base.Charsets;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;
import com.google.common.io.Resources;

public class ListFile {
    // try to make *all* variables final as possible
    private final Map<String, List<String>> adjacencyList;

    public ListFile(String filepath) {
        ListMultimap<String, String> multimap = ArrayListMultimap.create();

        try {
            // use Guava to read file from resources folder
            String content = Resources.toString(
                Resources.getResource(filepath),
                Charsets.UTF_8
            );

            Arrays.stream(content.split("\n"))
                .forEach(value -> {
                    AtomicReferenceArray<String> parts =
                        new AtomicReferenceArray<>(value.split(":"));

                    Arrays.stream(parts.get(1).split("\\s"))
                        .forEach(listValue -> {
                            multimap.put(parts.get(0), listValue);
                        });
                });
        } catch (IOException e) {
            // in case of error, always log error!
            System.err.println("ListFile has trouble reading file");
            e.printStackTrace();
        }

        adjacencyList = Multimaps.asMap(multimap);
    }

    public List<String> getList(String key) {
        return adjacencyList.get(key);
    }
}
