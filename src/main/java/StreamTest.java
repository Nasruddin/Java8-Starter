import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nasir on 12/12/15.
 */
public class StreamTest {

    final static List<String> friends = Arrays.asList("Asmit", "Feroz", "Joginder", "Manjinder", "Fahim");
    static List<String> upperCaseName = new ArrayList<>();

    public static void main(String[] args) {
        getFriends();
        getFriendsUpperCase();
    }

    public static void getFriends() {

        for (int i = 0; i < friends.size(); i++) {
            System.out.println("Old for loop : " + friends.get(i));
        }

        for (String friend : friends) {
            System.out.println("Foreach loop : " + friend);
        }

        friends.forEach((final String name) -> System.out.println("Java 8 way : " + name));

        friends.forEach((name) -> System.out.println("Java 8 way : " + name));

        friends.forEach(System.out::println);
    }

    public static void getFriendsUpperCase() {

        for (String name : friends) {
            upperCaseName.add(name.toUpperCase());
        }
        System.out.println("Old Java way : " + upperCaseName);

        friends.forEach(friend -> upperCaseName.add(friend.toUpperCase()));
        System.out.println("Java 8 way : " + upperCaseName);

        friends.stream()
               .map(name -> name.toUpperCase())
               .forEach(name -> System.out.println(name + " "));
        System.out.println();

        friends.stream()
               .map(name -> name.length())
               .forEach(count -> System.out.println(count + " "));

        friends.stream()
               .map(String::toUpperCase)
               .forEach(name -> System.out.println(name));
    }
}
