import java.util.*;

/**
 * Created by USER on 2016-12-16.
 */
public class Generics {
    static <T> void method(List<T> list) {

    }

    // ? 메소드 안에서 사용 않음
    static void method2(List<?> list) {
        //list.add(null);
        list.size();
        //list.clear();
        Iterator<?> it = list.iterator();
    }

    // ? 메소드 안에서 사용 못함
    static void method3(List<Object> list) {
        list.add(null); //null 값만 넣을수 있음 (원소의 처리는 못함)
        list.size();
        list.clear();
        Iterator<?> it = list.iterator();
    }

    /*private static <T> boolean isEmpty(List<T> list) {
        return list.size() == 0;
    }*/

    /**
     * 순수 리스트 기능만 사용
     * @param list
     * @return
     */
    private static boolean isEmpty(List<?> list) {
        return list.size() == 0;
    }

    /**
     * ? Generic Object Method는 사용할 수 있음 (내부구현과 무관함)
     * @param list
     * @param elem
     * @param <T>
     * @return
     */
    private static long frequency(List<?> list, Object elem) {
        return list.stream().filter(s-> s.equals(elem)).count();
    }

    /**
     * T Generic 사용은 T 내부구현의 관심이 있음
     */
    /*private static <T> long frequency(List<T> list, T elem) {
        return list.stream().filter(s-> s.equals(elem)).count();
    }*/

    /**
     * (<T extends Comparable<T>>) Upper Bounded Type
     * @param list
     * @param <T>
     * @return
     */
    /*private static <T extends Comparable<T>> Optional<T> max(List<T> list) {
        return list.stream().max((a, b) -> a.compareTo(b));
        //return list.stream().reduce((a,b) -> a.compareTo(b) > 0 ? a : b);
    }*/

    private static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        return list.stream().max((a, b) -> a.compareTo(b)).get();
        //return list.stream().reduce((a,b) -> a.compareTo(b) > 0 ? a : b);
    }

    /*private static <T> void reverse(List<T> list) {
        List<T> temp = new ArrayList<T>(list);
        int size = temp.size();
        for(int i =0; i < list.size(); i++) {
            list.set(i, temp.get(size - i -1));
        }
    }*/

    private static void reverse(List<?> list) {
        reverseHelper(list);

        // raw Type 으로 전환해서 사용
        /*List temp = new ArrayList<>(list);
        List list2 = list;
        int size = temp.size();

        for(int i =0; i < list.size(); i++) {
            list2.set(i, temp.get(size - i -1));
        }*/
    }

    /**
     * ? 사용시 Capture 오류시 Helper Method 사용
     * @param list
     * @param <T>
     */
    private static <T> void reverseHelper(List<T> list) {
        List<T> temp = new ArrayList<>(list);
        int size = temp.size();
        for(int i =0; i < list.size(); i++) {
            list.set(i, temp.get(size - i -1)); // Capture error
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5, 3, 1, 3);
        method(list);
        method2(list);
        // List(Object) = List(Integer) 않됨
        //method3(list);
        System.out.println(isEmpty(list));

        System.out.println(frequency(list, 1));

        System.out.println(max(list));

        System.out.println(Collections.max(list, (a, b) -> a - b));
        //System.out.println(Collections.max(list, (Comparator<Object)(a, b) -> a.toString().compareTo(b.toString())));

        reverse(list);
        // reverse execution
        System.out.println(list);
    }




}
