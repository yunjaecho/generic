import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

/**
 * Created by USER on 2017-08-29.
 */
public class Generics {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,5,3,8,1);
        System.out.println(max(list));
    }

    public static <T extends Comparable<T>> T max(List<T> list) {
        return list.stream().reduce((a, b ) -> a.compareTo(b) > 0 ? a: b).get();
    }
}
