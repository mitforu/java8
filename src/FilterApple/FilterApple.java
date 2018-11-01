package FilterApple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilterApple {

    public List<Apple> filterGreenAppleAttemp(List<Apple> apples){
        List<Apple> result = new ArrayList<Apple>();

        for (Apple apple: apples){
            if("Green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterAppleByColor(List<Apple> apples, String color){
        List<Apple> result = new ArrayList<Apple>();

        for (Apple apple: apples){
            if(color.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterAppleByWeight(List<Apple> apples, Integer weight){
        List<Apple> result = new ArrayList<Apple>();

        for (Apple apple: apples){
            if(apple.getWeight() > weight){
                result.add(apple);
            }
        }
        return result;
    }


    public List<Apple> filterApple(List<Apple> apples, String color , Integer weight, boolean flag){
        List<Apple> result = new ArrayList<Apple>();

        for (Apple apple: apples){
            if((flag && apple.getColor().equals(color) || (!flag && apple.getWeight() > weight))){
                result.add(apple);
            }
        }
        return result;
    }

    public List<Apple> filterApple(List<Apple> apples, ApplePredicate p){
        List<Apple> result = new ArrayList<Apple>();

        for (Apple apple: apples){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
