package Stream;

import java.util.Arrays;
import java.util.List;

public class StreamReduce {
    public static void main(String args[]){

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        int sum = 0;
        for (int x : numbers) {
            sum += x;
        }

        System.out.println("Sum of Numbers: "+ sum);


        // java 8 way
        Integer sumOfNumbers = numbers.stream().reduce(0, (a,b) -> a+b);
        System.out.println("Sum of Numbers: "+ sumOfNumbers);

    }
}
