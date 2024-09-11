package lambdasinaction._01lambda.functional.operator;

import java.util.function.IntBinaryOperator;

public class OperatorExample {
	private static int[] scores = { 92, 95, 87 };

	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.applyAsInt(result, score);
		}
		return result; }

	public static void main(String[] args) {
		// 최대값 얻기
		//1. Anonymous Inner class
		maxOrMin(new IntBinaryOperator() {
			@Override
			public int applyAsInt(int left, int right) {
				if(left >= right) return left;
				else return right;
			}
		});
		//2. Lambda 식
		int max = maxOrMin((n1,n2) -> Math.max(n1,n2));
		//3. Method Reference
		max = maxOrMin(Math::max);
		System.out.println("max = " + max);
		
		// 최소값 얻기
		int min = maxOrMin(Math::min);
		System.out.println("min = " + min);
	}
}
