package FunctionalInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalInterface {
    static Map<Integer, Person> personMap = new HashMap<Integer, Person>();
    public static void main(String args[]){
        personMap.put(1, new Person(1, "ABC"));
        personMap.put(2, new Person(2, "XYZ"));

        // Consumer
        Consumer<String> printTheResult = (String s) -> System.out.println(s);
        printValue(printTheResult,"Hello How are you");


        Function<Integer, Person> personSearch = (Integer id) -> personMap.get(id);
        System.out.println(personFinder(personSearch, 1));
    }

    // Consumer
    public static void printValue(Consumer<String> consumer, String result){
        consumer.accept(result);
    }

    public static Person personFinder(Function<Integer, Person> personFinderFunction, Integer id){
        return personFinderFunction.apply(id);
    }

}
