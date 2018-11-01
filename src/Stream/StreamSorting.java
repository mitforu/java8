package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSorting {
    public static void main(String args[]) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 800, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("beans", false, 550, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );



        List<Dish> sortedMenu = menu.stream()
                .sorted(
                        Comparator.comparing(Dish::getCalories)
                                .thenComparing(Dish::getName)
                ).collect(Collectors.toList());
        System.out.println(sortedMenu);
    }


}
