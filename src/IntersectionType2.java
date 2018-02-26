import java.util.function.Function;

/**
 * Created by USER on 2018-02-26.
 */
public class IntersectionType2 {
    interface Hello {
        default void hello() {
            System.out.println("Hello");
        }
    }

    interface Hi {
        default void hi() {
            System.out.println("Hi");
        }
    }

    private static <T extends Function & Hello & Hi> void hello(T t) {
        t.hello();
        t.hi();
    }

    public static void main(String[] args) {
        // 일반 구현해야할 method 갯수가 1개 (default method 제외)
        hello((Function & Hello & Hi) s -> s);
    }

}
