package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.toList;

/**
 * Created by USER on 2017-08-30.
 */
public class SortingDemo {
    private List<String> sampleStrings = Arrays.asList("this", "is", "a", "list", "of", "strings");

    // Default sort from Java 7
    public List<String> alphaSort() {
        Collections.sort(sampleStrings);
        return sampleStrings;
    }

    // Default sort from Java 8
    public List<String> alpaSortUsingStreams() {
        return sampleStrings.stream().sorted().collect(toList());
    }

    public List<String> lengthReverseSortWithComparator() {
        Collections.sort(sampleStrings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        return sampleStrings;
    }

    public List<String> lengthSortWithLanda() {
        Collections.sort(sampleStrings, (s1, s2) -> s1.length() - s2.length());
        return sampleStrings;
    }

    public List<String> lengthSortUsingSorted() {
        return sampleStrings.stream().sorted((s1, s2) -> s1.length() - s2.length()).collect(toList());
    }

    public List<String> lengthSortUsingComparator() {
        return sampleStrings.stream()
                .sorted(comparing(String::length)).collect(toList());
    }

    public List<String> lengthSortThenAlpaSortUsingSorted() {
        return sampleStrings.stream()
                .sorted(comparingInt(String::length).thenComparing(naturalOrder()))
                .collect(toList());
    }

    public List<String> lengthSortThenReverseAlpaSortUsingSorted() {
        return sampleStrings.stream()
                .sorted(comparingInt(String::length).thenComparing(reverseOrder()))
                .collect(toList());
    }



    public static void main(String[] args) {

    }
}
