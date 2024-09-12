package lambdasinaction._02stream.basic2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;


public class _05Reducing {

    public static void main(String... args) {

        //reduce - a + b 연산
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        //1. reduce() 메서드를 구현해서 합계 구하기
        int sum = numbers.stream()
                //.reduce(0, (n1,n2) -> n1 + n2);
                .reduce(0, Integer::sum);
        System.out.println("sum = " + sum);

        //2. IntStream 의 sum() 사용해서 합계 구하기
        sum = numbers.stream()
                //mapToInt(ToIntFunction) int applyAsInt(T value);
                //.mapToInt(value -> value.intValue()) //IntStream
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("sum2 = " + sum);

        //3. Stream 의 flatMapToInt() 생성한 IntStream 의 sum() 사용해서 합계 구하기
        //IntStream flatMapToInt(Function<? super T,? extends IntStream> mapper)
        sum = numbers.stream()
                //.flatMapToInt(value -> IntStream.of(value))
                .flatMapToInt(IntStream::of) //IntStream
                .sum();
        System.out.println("sum3 = " + sum);

        //1. Stream 의 reduce() 메서드 구현 - 최대값 구하기
        int max = numbers.stream()
                //.reduce(0, (n1,n2) -> Integer.max(n1,n2));
                .reduce(0, Integer::max);
        System.out.println("max = " + max);

        //2. Stream 의 max() 메서드 사용 - 최대값 구하기
        max = numbers.stream()
                //max(Comparator)
                //max((n1,n2) -> n1.compareTo(n2))
                .max(Integer::compareTo) //Optional<Integer>
                //.get();
                .orElse(0);
        System.out.println("Stream max = " + max);

        //reduce -  최소값
        int min = numbers.stream()
                .reduce(Integer::min) //Optional<Integer>
                .orElse(0);
        System.out.println("min = " + min);

        Optional<Integer> optional = numbers.stream().reduce(Integer::min);
        optional.ifPresent(System.out::println);

        //Dish 의  총 칼로리 합계를 구하는 여러가지 방법




    }
}
