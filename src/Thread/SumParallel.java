package Thread;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumParallel {
    public static void main(String args[]){

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        List<Integer> result = numbers.parallelStream().filter(it -> it/2 == 0 ).collect(Collectors.toList());


        System.out.println("Result "+ result);


        System.out.println("Sum 1 to 100" + IntStream.range(1,100).parallel().sum());
    }
}
