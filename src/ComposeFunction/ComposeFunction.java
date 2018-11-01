package ComposeFunction;

import java.util.function.BiFunction;

public class ComposeFunction {
    public static void main(String args[]) {

        Integer sum = getMethod("SUM").apply(1, 2);
        System.out.println(sum);

        Integer result = getMethod("SUM").andThen(value -> value*2).apply(1,2);
        System.out.println(result);
    }

    public static BiFunction<Integer, Integer, Integer> getMethod(String operation) {
        if (operation.equals("SUM")) {
            return (Integer op1, Integer op2) -> op1 + op2;
        } else if (operation.equals("MULTI")) {
            return (Integer op1, Integer op2) -> op1 * op2;
        } else {
            return (Integer op1, Integer op2) -> op1 - op2;
        }
    }

}
