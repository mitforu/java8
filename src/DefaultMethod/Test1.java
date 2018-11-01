package DefaultMethod;

public interface Test1 {
    default String foo(String s){
        return "Hello "+ s;
    }
}
