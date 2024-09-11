package lambdasinaction._01lambda.basic1;

import java.util.*;
import java.util.function.Consumer;

public class FilteringApples {

	public static void main(String... args) {

		List<Apple> inventory =
				Arrays.asList(new Apple(80, "green"),
						new Apple(155, "green"),
						new Apple(120, "red"));

		//filter method 호출
		//1. Anonymous Inner Class
		filter(inventory, new ApplePredicate<Apple>() {
			@Override
			public boolean test(Apple a) {
				return a.getColor().equals("green");
			}
		}).forEach(new Consumer<Apple>() {
			@Override
			public void accept(Apple apple) {
				System.out.println(apple);
			}
		});

		//2. Lambda 식
		System.out.println("===> 람다식");
		filter(inventory, apple -> apple.getColor().equals("red"))
				.forEach(apple -> System.out.println("Red Apple " + apple));

		//3. Method Reference
		System.out.println("===> Method Reference");
		filter(inventory, apple -> apple.getWeight() > 100)
				.forEach(System.out::println);
	}

	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if ("green".equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getColor().equals(color)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > weight) {
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filter(List<Apple> inventory, ApplePredicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	@FunctionalInterface
	interface ApplePredicate<Apple> {
		public boolean test(Apple a);
	}

	static class AppleWeightPredicate implements ApplePredicate<Apple> {
		public boolean test(Apple apple) {
			return apple.getWeight() > 150;
		}
	}

	static class AppleColorPredicate implements ApplePredicate<Apple> {
		public boolean test(Apple apple) {
			return "green".equals(apple.getColor());
		}
	}

	static class AppleRedAndHeavyPredicate implements ApplePredicate<Apple> {
		public boolean test(Apple apple) {
			return "red".equals(apple.getColor()) && apple.getWeight() > 150;
		}
	}
}