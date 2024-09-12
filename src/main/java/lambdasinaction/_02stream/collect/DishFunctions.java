package lambdasinaction._02stream.collect;

import java.util.Comparator;
import java.util.function.Function;

public class DishFunctions {
    //------------- 공통 메서드 시작 -------------
    static Function<Dish, Dish.Type> getTypeFunction() {
        return Dish::getType;
    }

    static Function<Dish, _04GroupingDishes.CaloricLevel> getCaloricLevelFunction() {
        return dish -> {
            if (dish.getCalories() <= 400) return _04GroupingDishes.CaloricLevel.DIET;
            else if (dish.getCalories() <= 700) return _04GroupingDishes.CaloricLevel.NORMAL;
            else return _04GroupingDishes.CaloricLevel.FAT;
        };
    }

    static Comparator<Dish> getDishComparator() {
        return Comparator.comparingInt(Dish::getCalories);
    }

    //------------- 공통 메서드 끝 -------------

}