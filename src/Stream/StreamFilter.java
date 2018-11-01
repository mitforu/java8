package Stream;

import FilterApple.Apple;

import java.util.Arrays;
import java.util.List;

public class StreamFilter {
    public static void main(String args[]){

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .peek(test -> System.out.println("Tapping:"+test))
                .distinct()
                .forEach(System.out::println);

        //filterApple();
    }

    public static void filterApple(){
        List<Apple> apples = Arrays.asList(
                new Apple("Green", 200),
                new Apple("Red", 50),
                new Apple("Red", 100),
                new Apple("Green", 100),
                new Apple("Red", 170),
                new Apple("Green", 160)
        );

        apples.stream().filter(apple -> apple.getColor().equals("Red")).forEach(System.out::println);
    }
}
