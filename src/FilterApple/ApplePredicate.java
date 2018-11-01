package FilterApple;

@FunctionalInterface
public interface ApplePredicate {
    boolean test(Apple apple);
}