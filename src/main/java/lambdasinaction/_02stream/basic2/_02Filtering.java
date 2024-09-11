package lambdasinaction._02stream.basic2;


import java.util.Arrays;
import java.util.List;

import lambdasinaction._02stream.basic1.Dish;
import static lambdasinaction._02stream.basic1.Dish.menu;

public class _02Filtering {

    public static void main(String...args){

        // 1. Filtering with predicate ( isVegeterian() )
        List<Dish> vegeList = menu.stream().filter(Dish::isVegetarian).toList();
        vegeList.forEach(System.out::println);

        // 2. Filtering unique elements
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .distinct()
                .toList()
                .forEach(System.out::println);

        //3. Truncating 3 stream ( d.getCalories() > 300 )
        List<Dish> dishesLimit3 = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .toList();
        dishesLimit3.forEach(System.out::println);

        System.out.println(">>>> Skip 2 Element");
        //4. Skipping elements
        List<Dish> dishesSkip2 = menu.stream().skip(2).toList();
        dishesSkip2.forEach(System.out::println);

    }
}
