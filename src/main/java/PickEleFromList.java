import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PickEleFromList {

    final static List<String> names =
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

    public static void main(String[] args) {
        pickName(names, "N");
        pickName8(names, "Z");
    }

    public static void pickName(List<String> names, String startingLetter) {

        String foundName = null;

        for (String name : names){
            if(name.startsWith(startingLetter)){
                foundName = name;
            }
        }

        System.out.println(String.format("A name starting with %s: ", startingLetter));

        if(foundName != null) {
            System.out.println(foundName);
        } else {
            System.out.printf("No name found");
        }

    }

    public static void pickName8(List<String> names, String startingLetter) {

        final Optional<String> foundName =
                names.stream()
                     .filter(name -> name.startsWith(startingLetter))
                     .findFirst();

        System.out.println(String.format("A name starting with %s: %s",
                startingLetter, foundName.orElse("No name found")));
    }
}
