import java.io.Serializable;
import java.util.function.Function;

/**
 * Created by USER on 2018-02-26.
 */
public class IntersectionType {

    public static void main(String[] args) {
        //hello((Function)s -> s);
        hello((Function & Serializable & Cloneable)s -> s);

        // (Function & Serializable) 전체 method 갯수가 1개 일때만
    }

    // maker interface : no method interface (Serializable, Cloneable)

    //private static void hello(Function o)  {
    private static <T extends Function & Serializable & Cloneable >void hello(T o)  {
        System.out.println(o.apply(o));
    }
}
