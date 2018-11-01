package DefaultMethod;

public interface Test2 {
    default String foo(String s){
        return "Hello "+ s;
    }
}
