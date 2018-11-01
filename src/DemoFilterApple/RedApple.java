package DemoFilterApple;

public class RedApple implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("Red");
    }
}
