package lambdasinaction._01lambda.functional;
import java.util.Comparator;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntBiFunction;

public class FunctionAndThenCompose {

	public static void main(String[] args) {
		
		//Function 조합
		Function<Integer,Integer> f = x -> x + 1;
		Function<Integer,Integer> g = x -> x * 2;
		//f를 부른 다음 g를 호출한다
		Function<Integer,Integer> h = f.andThen(g);
		
		System.out.println(h.apply(2)); //6
		//Function 조합
		Function<Integer,Integer> i = x -> x + 1;
		Function<Integer,Integer> j = x -> x * 2;
		//j를 부른 다음 i를 호출한다
		Function<Integer,Integer> k = i.compose(j);
		
		System.out.println(k.apply(2)); //5

		ToIntBiFunction<Integer,Integer> intBiFunc = (x1, x2) -> x1 + x2;
		intBiFunc = (x1, x2) -> Integer.sum(x1, x2);
		intBiFunc = Integer::sum;

		IntUnaryOperator intUnaryOp = x -> x + 1;
	}

}
