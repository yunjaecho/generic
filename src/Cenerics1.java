import java.util.*;

/**
 * Created by USER on 2018-02-22.
 */
public class Cenerics1 {

    static class MyList<E, P> implements List<E> {

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<E> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(E e) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends E> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public E get(int index) {
            return null;
        }

        @Override
        public E set(int index, E element) {
            return null;
        }

        @Override
        public void add(int index, E element) {

        }

        @Override
        public E remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<E> listIterator() {
            return null;
        }

        @Override
        public ListIterator<E> listIterator(int index) {
            return null;
        }

        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            return null;
        }
    }

    static <T> void method(T t, List<T> list) {}

    static <T> void method2(List<T> t) {}

    static void method3(List<?> t) {}

    static void printList(List<Object> list) {
        list.forEach(s -> System.out.println(s.toString()));
    }

    static void printList2(List<?> list) {
        list.forEach(s -> System.out.println(s.toString()));
    }

    public static void main(String[] args) {
        Integer i = 10;
        Number n = i;

        List<Integer> intList = new ArrayList<>();
        //List<Number> = intList

        ArrayList<Integer> arrayList = new ArrayList<>();
        //List<Integer> integerList = arrayList

//        List<String> s1 = new MyList<String, Integer>()
//        List<String> s2 = new MyList<String, Integer>()

        // JAVA 8 버전 이전에서 문제가 발생할수 있는것 방지
        // Type witness
        Cenerics1.<Integer>method(1, Arrays.asList(1,2,3,4));

        // 타입 추론
        List<String> list = new ArrayList<>();
        List<String> c = Collections.<String>emptyList();

        printList(Arrays.asList(1,2,3));
        printList2(Arrays.asList(1,2,3));

        List<Integer> list2 = Arrays.asList(1,2,3);
//        printList(list);
        printList2(list);
    }
}
