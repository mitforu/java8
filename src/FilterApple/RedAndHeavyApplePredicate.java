package FilterApple;

public class RedAndHeavyApplePredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "Red".equals(apple.getColor()) && apple.getWeight() > 150;
    }
}
