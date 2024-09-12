package lambdasinaction;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LambdaTest {
    /*
        java.util.function 에 제공하는 함수형 인터페이스
        Consumer -  void accept(T t)
        Predicate - boolean test(T t)
        Supplier - T get()
        Function - R apply(T t)
        Operator -
           UnaryOperator : R apply(T t)
           BinaryOperator : R apply(T t, U u)
    */
    @Test @Disabled
    public void lambdaTest() {
        //Functional Interface 가 가진 추상메서드를 재정의할때 람다식으로 작성하기

        /*
            class MyRunnable implements Runnable{ }
            new Thread(new MyRunnable());
         */
        //1. Anonymous Inner Class
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Inner Class");
            }
        });
        t1.start();

        //2. Lambda Expression
        Thread t2 = new Thread(() -> System.out.println("Lambda Expression"));
        t2.start();

        //Immutable List
        List<String> stringList = List.of("abc", "java", "boot");

        //1. Anonymous Inner Class
        //Iterable forEach()
        stringList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("s = " + s);
            }
        });

        //2. Lambda Expression
        stringList.forEach(val -> System.out.println("val = " +val));
        //3. Method Reference
        stringList.forEach(System.out::println);
    }


    @Test
    void sorted() {
        Stream.of("java","test","scala","aaa")
                .sorted()
                .forEach(System.out::println);
    }

}