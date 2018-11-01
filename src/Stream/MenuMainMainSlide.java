package Stream;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class MenuMainMainSlide {
    public static void main(String args[]){
        /*
            Sorting Dish by calories
         */
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


        List<Dish> lowCaloryDishOldWay = new ArrayList<Dish>();

        for (Dish dish: menu){
            if(dish.getCalories() < 400){
                lowCaloryDishOldWay.add(dish);
            }
        }

        Collections.sort(lowCaloryDishOldWay, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return o1.getCalories() - o2.getCalories();
            }
        });

        List<String> lowCaloryDishNameOldWay = new ArrayList<String>();

        for (Dish dish: lowCaloryDishOldWay){
            lowCaloryDishNameOldWay.add(dish.getName());
        }

        System.out.println(lowCaloryDishNameOldWay);

        // JAVA 8 WAY
        List<String> lowCaloricDishesName =
                menu.parallelStream()
                        .filter(d -> d.getCalories() < 400)
                        .sorted(comparing(Dish::getCalories))
                        .map(Dish::getName)
                        .collect(toList());

        System.out.println(lowCaloricDishesName);
    }
}
