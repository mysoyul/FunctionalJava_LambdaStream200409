package lambdasinaction._01lambda.functional.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {

	public static List<String> getColorList(List<Apple> inventory,
											Function<Apple, String> function) {
		List<String> colorList = new ArrayList<String>();
		for (Apple apple : inventory) {
			colorList.add(function.apply(apple));
		}
		return colorList;
	}

	public static void main(String[] args) {
		List<Apple> inventory = new ArrayList<>();
		inventory.add(new Apple(150, "green"));
		inventory.add(new Apple(200, "green"));
		inventory.add(new Apple(200, "red"));
		inventory.add(new Apple(150, "red"));

		// 1. using anonymous inner class
		getColorList(inventory,new Function<Apple, String>() {
			@Override
			public String apply(Apple apple) {
				return apple.getColor();
			}
		});

		// 2. lambda expression
		getColorList(inventory, apple -> apple.getColor());

		// 3. Method Reference
		getColorList(inventory, Apple::getColor).forEach(System.out::println);
		Function<Apple, String> getColorFunc = Apple::getColor;
		getColorList(inventory, getColorFunc);

	}

	public static class Apple {
		private Integer weight = 0;
		private String color = "";

		public Apple(Integer weight, String color) {
			this.weight = weight;
			this.color = color;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String toString() {
			return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
		}
	}
}
