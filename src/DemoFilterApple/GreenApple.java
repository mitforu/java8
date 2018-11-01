package DemoFilterApple;

public class GreenApple implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("Green");
    }
}
