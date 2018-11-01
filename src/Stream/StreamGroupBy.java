package Stream;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class StreamGroupBy {
    public static void main(String args[]){
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("beans", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        Map<Dish.Type , List<Dish>> menuGroupByDishType = new HashMap<>();

        for (Dish dish: menu){
            if (menuGroupByDishType.get(dish.getType()) == null){
                List<Dish> dishes = new ArrayList<>();
                dishes.add(dish);
                menuGroupByDishType.put(dish.getType(), dishes);
            }else {
                List<Dish> dishes = menuGroupByDishType.get(dish.getType());
                dishes.add(dish);
            }
        }

        System.out.println(menuGroupByDishType);


        // Java 8 way
        Map<Dish.Type , List<Dish>> menuGroupByDishTypeJava8Way = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(menuGroupByDishTypeJava8Way);
    }
}
