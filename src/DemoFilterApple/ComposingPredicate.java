package DemoFilterApple;

import FilterApple.Apple;

import java.util.function.Predicate;

public class ComposingPredicate {
    public static void main(String args[]){
        Predicate<Apple> redApple = apple -> apple.getColor().equals("Red");
        Predicate<Apple> notRedApple = redApple.negate();

        Predicate<Apple> lightApple = apple -> apple.getWeight() < 150;
        Predicate<Apple> redAndLightApple = redApple.and(lightApple);
    }
}
