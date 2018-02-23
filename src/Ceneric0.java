import java.io.Closeable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by USER on 2018-02-23.
 */
public class Ceneric0 {
    // T : List, Serializable, Comparable, Closeable(Intersection Type) 모드 만족하는 하위 클래스
    // extends 복합적일때는 클래스는 하나만
    static <T extends List & Serializable & Comparable & Closeable>void print(T t) {
    }

//    static long countGreaterThan(Integer[] arr, Integer elem) {
//        return Arrays.stream(arr).filter(s -> s > elem).count();
//    }

    //    static <T > long countGreaterThan(T[] arr, T elem) {
//        return Arrays.stream(arr).filter(s -> s > elem).count();
//    }
    static <T extends Comparable<T>> long countGreaterThan(T[] arr, T elem) {
        return Arrays.stream(arr).filter(s -> s.compareTo(elem) > 0).count();
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,6};
        System.out.println(countGreaterThan(arr, 2));

        String[] arr2 = new String[]{"a", "b", "c","d"};
        System.out.println(countGreaterThan(arr2, "c"));

        Number i;
    }
}
