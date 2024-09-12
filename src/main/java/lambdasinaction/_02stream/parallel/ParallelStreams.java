package lambdasinaction._02stream.parallel;

import java.util.stream.*;

public class ParallelStreams {
    //기존 For Loop
    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    //순차스트림 - 크기가 고정 되지 않고, Unboxing 비용이 발생하는 스트림
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(Long::sum)
                .get();
    }
    
    //병렬스트림 - 크기가 고정 되지 않고, Unboxing 비용이 발생하는 스트림
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(Long::sum)
                .get();
    }

    //순차스트림 - 크기가 고정된 LongStream
    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(Long::sum)
                .getAsLong();
    }

    //병렬스트림 - 크기가 고정된 LongStream
    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(Long::sum)
                .getAsLong();
    }
    
    //순차스트림 - Accumulator 사용
    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }
    
    //병렬스트림 - Accumulator 사용, 동시성 문제 발생됨
    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n)
                .parallel()
                .forEach(accumulator::add);
        return accumulator.total;
    }

    public static class Accumulator {
        private long total = 0;

        public void add(long value) {
            total += value;
        }
    }
}
