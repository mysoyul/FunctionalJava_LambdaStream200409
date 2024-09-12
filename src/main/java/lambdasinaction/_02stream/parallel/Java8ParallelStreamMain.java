package lambdasinaction._02stream.parallel;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Java8ParallelStreamMain {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("=================================");
        System.out.println("Using Sequential Stream");
        System.out.println("=================================");

        //Sequential Stream
        IntStream intArrStream = Arrays.stream(array);
        intArrStream.forEach(s ->
                {
                    //main
                    System.out.println(s + " " + Thread.currentThread().getName());
                }
        );

        System.out.println("=================================");
        System.out.println("Using Parallel Stream");
        System.out.println("=================================");

        //Parallel Stream
        IntStream intParallelStream = Arrays.stream(array).parallel();
        intParallelStream.forEach(s ->
                {
                    //ForkJoinPool.commonPool-worker-1
                    System.out.println(s + " " + Thread.currentThread().getName());
                }
        );
    }
}