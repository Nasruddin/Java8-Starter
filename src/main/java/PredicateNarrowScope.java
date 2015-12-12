import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by nasir on 12/12/15.
 */
public class PredicateNarrowScope {

    public static void main(String[] args) {

    }

    final Function<String, Predicate<String>> startsWithLetter =
            (String letter) -> {
                Predicate<String> checkStartsWith =
                        (String name) -> name.startsWith(letter);
                return checkStartsWith;
            };
}
