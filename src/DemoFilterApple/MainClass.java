package DemoFilterApple;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MainClass {
    public static void main(String args[]){
        List<Apple> apples = Arrays.asList(
                new Apple("Green", 200),
                new Apple("Red", 50),
                new Apple("Red", 100),
                new Apple("Green", 100),
                new Apple("Red", 170),
                new Apple("Green", 160)
        );

        List<Apple> lightApple = getApples(apples, apple -> apple.getWeight() < 100);

        System.out.println(lightApple);

    }




    private static List<Apple> filterApple(List<Apple> apples, String color, Integer weight, boolean flag){
        List<Apple> redApple = new ArrayList<>();

        for (Apple apple: apples){
            if (flag && apple.getColor().equals(color) || !flag && apple.getWeight() < weight){
                redApple.add(apple);
            }
        }
        return redApple;
    }

    private static List<Apple> getApples(List<Apple> apples, Predicate<Apple> applePredicate) {
        List<Apple> redApple = new ArrayList<>();

        for (Apple apple: apples){
            if (applePredicate.test(apple)){
                redApple.add(apple);
            }
        }
        return redApple;
    }

    private static List<Apple> getLightApples(List<Apple> apples, Integer weight) {
        List<Apple> finalAppleList = new ArrayList<>();

        for (Apple apple: apples){
            if (apple.getWeight() < weight){
                finalAppleList.add(apple);
            }
        }
        return finalAppleList;
    }
}
