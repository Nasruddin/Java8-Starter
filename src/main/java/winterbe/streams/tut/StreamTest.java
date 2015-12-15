package winterbe.streams.tut;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nasir on 13/12/15.
 */
public class StreamTest {

    public static void main(String[] args) {

        List<String> myList = Arrays.asList("a1", "a2", "b1", "b2", "c3", "c1", "c2");

        List<Person> persons = Arrays.asList(
                new Person("Nasir", 26),
                new Person("Asmit", 27),
                new Person("Joginder", 25),
                new Person("Nasir2", 26),
                new Person("Asmit2", 27),
                new Person("Joginder2", 25)
        );

        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
            System.out.println("Filter : " + s);
            return true;
        }).forEach(s -> System.out.println("Foreach : " +s));

        List<Person> filterPerson =
                                    persons
                                            .stream()
                                            .filter(p -> p.getName().startsWith("N"))
                                            .collect(Collectors.toList());

        System.out.println(filterPerson);

    }
}
