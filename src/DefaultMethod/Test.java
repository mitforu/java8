package DefaultMethod;

public class Test implements Test1,Test2{
    @Override
    public String foo(String s) {
        return Test1.super.foo(s);
    }
}
