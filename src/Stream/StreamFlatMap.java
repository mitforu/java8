package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFlatMap {
    public static void main(String args[]) {
        List<List<Integer>> integers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );


//        [ 1,2,3, 6,5,4]

//        List<Stream<Integer>> streamOfStream = integers.stream().map(Collection::stream).collect(Collectors.toList());

//        streamOfStream.stream().forEach(System.out::println);

        // java 8 way
        // integers.stream().map(it -> it.stream()).flatMap(it -> it).forEach(System.out::println);


         flatMapRealWorldExample();
    }

    private static void flatMapRealWorldExample() {
        List<Person> persons = Arrays.asList(
                new Person(
                        "Person1",
                        Arrays.asList("234-234-3423", "234-111-2222"),
                        Arrays.asList(
                                new Address("Street 1", "Chicago"),
                                new Address("Street 11", "London")
                        )
                ),
                new Person(
                        "Person2",
                        Arrays.asList("342-555-9878", "234-111-2222"),
                        Arrays.asList(
                                new Address("Street2", "Chicago"),
                                new Address("Street22", "Chicago")
                        )
                ),
                new Person(
                        "Person3",
                        Arrays.asList("765-555-0978", "234-111-2222"),
                        Arrays.asList(
                                new Address("Street3", "Miami")
                        )
                ),
                new Person(
                        "Person3",
                        Arrays.asList("765-555-0978", "234-111-2222"),
                        Arrays.asList(
                                new Address("Street4", "Chicago")
                        )
                ),
                new Person(
                        "Person3",
                        Arrays.asList("765-555-0978", "234-111-2222"),
                        Arrays.asList(
                                new Address("Street4", "New York")
                        )
                )
        );


        // Get all the streets names of people whose address is in chicago
        List<String> streetNames = new ArrayList<>();
        for (Person person : persons) {
            for (Address address : person.getAddresses()) {
                if (address.getCity().equals("Chicago")) {
                    streetNames.add(address.getStreet());
                }
            }
        }

        System.out.println("All street address in chicago " + streetNames);

        // [ Peson -> [a1, a2], Peson -> [a3, a4]]
        // [ a1, a2, a3, a4]

        // java 8 way
        streetNames = persons
                .stream()
                .flatMap(it -> it.getAddresses().stream())
                .filter(it -> it.getCity().equals("Chicago"))
                .map(it -> it.getStreet())
                .collect(Collectors.toList());
        System.out.println("All street address in chicago " + streetNames);
    }
}
