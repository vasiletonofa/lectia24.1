package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamService {


    public List<Person> filterByName(List<Person> personList, String name) {
        List<Person> people = new ArrayList<>();

        for(Person person : personList) {
            if(person.getName().contains(name)) {
                people.add(person);
            }
        }

        return people;
    }

    public List<Person> filterByNameWithStream(List<Person> personList, String name) {
     return personList.stream()
             .filter(s -> s.getName().contains(name))
             .collect(Collectors.toList());
    }


    public List<Person> filterByAgeWithStream(List<Person> personList, int age) {
        return personList.stream()
                .filter(s -> s.getAge() == age)
                .collect(Collectors.toList());
    }

    public List<Person> celebrateBirthDay(List<Person> personList, String name) {
        return personList.stream()
//                .filter(s -> s.getName().contains(name)) // Andrei Lungu 23
                .map(t -> {
                    if(t.getName().contains(name)) {
                        t.setAge(t.getAge() + 1);
                    }
                    return t;
                }) // toate persoanele, Lungu va fi cu varsta incrementata
                .collect(Collectors.toList());

    }

    public long countByAge(List<Person> personList, int age) {
        return personList.stream()
                .filter(s -> s.getAge() == age)
                .count();
    }

    public Person findPersonByNameFirst(List<Person> personList, String name) {
        List<Person> people = personList.stream()
                .filter(s -> s.getName().contains(name))
                .collect(Collectors.toList());
        if (people.size() > 0) {
            return people.get(0);
        } else {
            return null;
        }
    }

    public Optional<Person> findPersonByNameOptional(List<Person> personList, String name) {
        return personList.stream()
                .filter(s -> s.getName().contains(name))
                .findAny();

    }
}
