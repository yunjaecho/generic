package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparingInt;

/**
 * Created by USER on 2017-08-30.
 */
public class SortGolfers {
    private List<Golfer> golfers = Arrays.asList(
            new Golfer("Jack", "Nickaus", 68),
            new Golfer("Tiger", "Woods", 70),
            new Golfer("Tom", "Watson", 70),
            new Golfer("Ty", "Webb", 68),
            new Golfer("Bubba", "Waston", 70)
    );

    public void defaultSort() {
        golfers.stream().sorted().forEach(System.out::println);
    }

    public void sortByScoreThenLast() {
        golfers.stream()
                .sorted(comparingInt(Golfer::getScore).thenComparing(Golfer::getLast))
                .forEach(System.out::println);
    }

    public void sortByscoreThenLastThenFirst() {
        golfers.stream()
                .sorted(comparingInt(Golfer::getScore)
                    .thenComparing(Golfer::getLast)
                    .thenComparing(Golfer::getFirst))
                .forEach(System.out::println);
    }


    public static void main(String[] args) {
        SortGolfers sortGolfers = new SortGolfers();
        sortGolfers.defaultSort();
        System.out.println("###############################");
        sortGolfers.sortByScoreThenLast();
        System.out.println("###############################");
        sortGolfers.sortByscoreThenLastThenFirst();
    }

}
