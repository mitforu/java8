package Stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamExample {

    public static void main(String args[]) {

        Map<Integer, String> numberToString = new HashMap();
        numberToString.put(1, "ONE");
        numberToString.put(2, "TWO");
        numberToString.put(3, "THREE");
        numberToString.put(4, "FOUR");

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);

        Stream<String> stringStream = integerStream.map(it -> numberToString.get(it));

        List<String> result = stringStream.collect(toList());

        System.out.println(result);

        // List<Integer> a = integerStream.map(it -> it).collect(toList());


        List<String> listOfStrings = Arrays.asList("a","b","c");

        Stream<String> streamOfString = listOfStrings.stream();
        streamOfString.forEach(System.out::println);
        streamOfString.forEach(System.out::println);
    }
}