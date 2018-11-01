package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamFind {
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

        boolean isMatchFound = false;
        for (Dish dish: menu){
            if(dish.isVegetarian() == true){
                isMatchFound = true;
                break;
            }
        }

        //Java 8 way
        System.out.println("Menu has Vegetarian Dish : "+ menu.stream().anyMatch(Dish::isVegetarian));


        boolean isAllMatchFound = true;
        for (Dish dish: menu){
            if(dish.getCalories() >= 1000){
                isAllMatchFound = false;
                break;
            }
        }

        //Java 8 way
        System.out.println("All dishes are under 1000 calories: " + menu.stream().allMatch(dish -> dish.getCalories() < 1000));


        Dish vegeterianDish = null;
        for (Dish dish: menu){
            if(dish.isVegetarian() == true){
                vegeterianDish = dish;
                break;
            }
        }

        // java 8 way
        Optional<Dish> dish =
                menu
                        .stream()
                        .peek(System.out::println)
                        .filter(Dish::isVegetarian)
                        .peek(System.out::println)
                        .findAny();

    }
}
