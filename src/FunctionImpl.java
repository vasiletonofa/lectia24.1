import java.util.function.Function;

public class FunctionImpl implements Function<String, String> {
    @Override
    public String apply(String s) { // A, C
        return s.toLowerCase(); // a, c
    }
}
