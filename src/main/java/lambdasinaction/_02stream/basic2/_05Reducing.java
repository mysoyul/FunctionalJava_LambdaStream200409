package lambdasinaction._02stream.basic2;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import lambdasinaction._02stream.basic1.Dish;

import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static lambdasinaction._02stream.basic1.Dish.menu;

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
                //Comparator 추상메서드 int compare(T o1, T o2)
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

        //IntStream average() 메서드로 평균 구하기
        double average =
                 numbers.stream()
                        .flatMapToInt(IntStream::of)
                        .average()
                        .orElse(0.0);
        System.out.println("average = " + average);

        //Dish 의  총 칼로리 합계를 구하는 여러가지 방법
        //1. reduce() 함수로 구현
        Integer totalValue = menu.stream() //Stream<Dish>
                .map(Dish::getCalories) //Stream<Integer>
                .reduce(0, (dish1, dish2) -> dish1 + dish2);
        System.out.println("totalValue = " + totalValue);

        //2. reduce() 함수에서 Integer.sum() 메서드 호출
        totalValue = menu.stream()
                .map(Dish::getCalories)
                .reduce(Integer::sum) //Optional<Integer>
                .orElse(0);
        System.out.println("totalValue2 = " + totalValue);

        //3. mapToInt()사용하여 IntStream 변환하여 sum() 호출 ( 권장 )
        totalValue = menu.stream()
                //.mapToInt(dish -> dish.getCalories())
                .mapToInt(Dish::getCalories) //IntStream
                .sum();
        System.out.println("totalValue3 = " + totalValue);

        //4. Collectors 의 summingInt() 호출
        totalValue = menu.stream()
                .collect(summingInt(Dish::getCalories));
        System.out.println("totalValue4 = " + totalValue);

        IntSummaryStatistics statistics = menu.stream()
                .collect(summarizingInt(Dish::getCalories));
        System.out.println("statistics = " + statistics);


        //5. IntStream  range() vs rangeClosed()
        IntSummaryStatistics statistics1 = IntStream.range(1, 100)
                .summaryStatistics();
        System.out.println("range() statistics =" + statistics1);

        IntSummaryStatistics statistics2 = IntStream.rangeClosed(1, 100)
                .summaryStatistics();
        System.out.println("rangeClosed() statistics =" + statistics2);


    }
}
