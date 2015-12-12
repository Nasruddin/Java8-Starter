import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by nasir on 12/12/15.
 */
public class ReUseLambdaExp {

    final static List<String> friends =
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    final static List<String> comrades =
            Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
    final static List<String> editors =
            Arrays.asList("Brian", "Jackie", "John", "Mike");

    public static void main(String[] args) {
        nameStartsWithChar();
    }

    public static Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }

    public static void nameStartsWithChar() {

        PredicateNarrowScope predicateNarrowScope = new PredicateNarrowScope();

        final List<String> namesStartsWithN =
                friends.stream()
                       .filter(name -> name.startsWith("N"))
                       .collect(Collectors.toList());
        System.out.println("Names starts with N count : " + namesStartsWithN.size());

        final Predicate<String> startsWithN = name -> name.startsWith("N");
        final Predicate<String> startsWithJ = name -> name.startsWith("J");

        final long countFriendsStartN =
                friends.stream().filter(name -> name.startsWith("N")).count();
        final long countComradesStartN =
                comrades.stream().filter(startsWithN).count();
        final long countEditorsStartN =
                editors.stream().filter(checkIfStartsWith("J")).count();
        final long countEditorsStartN1 =
                editors.stream().filter(predicateNarrowScope.startsWithLetter.apply("J")).count();

        System.out.println("Friends with N : " +countFriendsStartN+
                            " Comrades with N : " +countComradesStartN+
                            " Editors with N : " +countEditorsStartN+
                            " Editors with N with Function Predicate : " +countEditorsStartN1);

    }
}
