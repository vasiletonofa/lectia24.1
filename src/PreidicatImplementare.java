import java.util.function.Predicate;

public class PreidicatImplementare implements Predicate<String> {

    @Override
    public boolean test(String s) { // A, B, C
       return s.equals("B") || s.equals("C");
    }
}
