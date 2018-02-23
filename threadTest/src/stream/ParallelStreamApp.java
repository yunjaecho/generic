package stream;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by USER on 2017-08-03.
 */
public class ParallelStreamApp {
    public static void main(String[] arg) throws ExecutionException, InterruptedException {
//        System.out.println( "parallelism : " + System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism"));
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "29");

        long start = System.currentTimeMillis();

        final ForkJoinPool forkJoinPool = new ForkJoinPool(30);

        forkJoinPool.execute(() -> {
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30)
                    .parallelStream()
                    .forEach(i -> {
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(i);
                    });
            System.out.println("###" + (System.currentTimeMillis() - start));
        });

        //forkJoinPool.awaitTermination(6, TimeUnit.SECONDS);
        forkJoinPool.awaitQuiescence(20, TimeUnit.SECONDS);

       /* ForkJoinTask<?> result = forkJoinPool.submit(() -> {
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30)
                    .parallelStream()
                    .forEach(i -> {
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(i);
                    });

        });
        result.get();*/

        //System.out.println(System.currentTimeMillis() - start);


    }
}
