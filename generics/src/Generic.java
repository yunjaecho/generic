import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by USER on 2017-08-28.
 */
public class Generic {
    public static double sumList(List<? extends Number> list) {
        return list.stream().mapToDouble(Number::doubleValue)
                .sum();
    }


    public static void main(String[] args) {
        List<? extends Number> numbers = new ArrayList<>();

//        numbers.add(3);
//        numbers.add(3.14159);
//        numbers.add(new BigDecimal("4)"));

        List<Integer> ints = Arrays.asList(1,2,3,4,5);
        List<String> strings = Arrays.asList("a", "b");
        List<Double> doubles = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        List<BigDecimal> bigDecimals = Arrays.asList(
                new BigDecimal("1"),
                new BigDecimal("2"),
                new BigDecimal("3"),
                new BigDecimal("4"),
                new BigDecimal("5")
        );

        System.out.println(sumList(ints));
        System.out.println(sumList(doubles));
        System.out.println(sumList(bigDecimals));
        //System.out.println(sumList(strings));

    }
}
