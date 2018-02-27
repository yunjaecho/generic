import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by USER on 2018-02-27.
 */
public class IntersectionType3 {
    interface Hello extends Function {
        default void hello() {
            System.out.println("Hello");
        }
    }

    interface Hi extends Function {
        default void hi() {
            System.out.println("Hi");
        }
    }

    interface Printer {
        default void print(String str) {
            System.out.println(str);
        }
    }

    private static <T extends Function & IntersectionType2.Hello & IntersectionType2.Hi> void hello(T t) {
        t.hello();
        t.hi();
    }


    public static void main(String[] args) {
        // 일반 구현해야할 method 갯수가 1개 (default method 제외)
        // Lambda 식에 있는 Type은 모든 Type의 induction 과정을 거쳐 동일한 시그너쳐 메소드는 1개만
        hello((Function & IntersectionType2.Hello & IntersectionType2.Hi) s -> s);

        System.out.println("#######################################");

        run((Function & IntersectionType2.Hello & IntersectionType2.Hi & IntersectionType2.Printer) s -> s, o -> {
            o.hello();
            o.hi();
            o.print("Lambda");
        });
    }

    private static <T extends Function> void run(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }
}
