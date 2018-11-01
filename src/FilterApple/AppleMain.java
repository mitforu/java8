package FilterApple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleMain {


    public static void main(String args[]){

        List<Apple> apples = Arrays.asList(
                new Apple("Green", 200),
                new Apple("Red", 50),
                new Apple("Red", 100),
                new Apple("Green", 100),
                new Apple("Red", 170),
                new Apple("Green", 160)
        );

        System.out.println("GREEN APPLES: " + new FilterApple().filterGreenAppleAttemp(apples));

        System.out.println("GREEN APPLES: " + new FilterApple().filterAppleByColor(apples, "Green"));
        System.out.println("RED APPLES: " + new FilterApple().filterAppleByColor(apples, "Red"));

        System.out.println("HEAVY APPLES:             " + new FilterApple().filterAppleByWeight(apples, 150));



        System.out.println("HEAVY APPLES filterApple: " + new FilterApple().filterApple(apples, "",150, false));

        System.out.println();
        System.out.println();


        System.out.println("GREEN APPLES: WITH PREDICATE" + new FilterApple().filterApple(apples, new AppleGreenColorPredicate()));
        System.out.println("HEAVY APPLES: WITH PREDICATE" + new FilterApple().filterApple(apples, new HeavyApplePredicate()));

        System.out.println("RED HEAVY APPLES: WITH PREDICATE" + new FilterApple().filterApple(apples, new RedAndHeavyApplePredicate()));

        List<Apple> redApples = new FilterApple().filterApple(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "Red".equals(apple.getColor());
            }
        });



        new FilterApple().filterApple(apples , (Apple apple) -> "Red".equals(apple.getColor()));

        new FilterApple().filterApple(apples , (apple) -> "Red".equals(apple.getColor()));




    }
}
