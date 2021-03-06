import java.util.function.Consumer;
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

    interface Printer {
        default void print(String str) {
            System.out.println(str);
        }
    }

    private static <T extends Function & Hello & Hi> void hello(T t) {
        t.hello();
        t.hi();
    }


    public static void main(String[] args) {
        // 일반 구현해야할 method 갯수가 1개 (default method 제외)
        hello((Function & Hello & Hi) s -> s);

        System.out.println("#######################################");

        run((Function & Hello & Hi & Printer) s -> s, o -> {
            o.hello();
            o.hi();
            o.print("Lambda");
        });
    }

    private static <T extends Function> void run(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }

}
