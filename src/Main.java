import streams.Person;
import streams.StreamService;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Mutable vs Immutable

        // Mutable -> La schimbare de valoare nu trebuie sa atribuim rezultatul la o variabila pentru ca nu se schimba adresa de memorie (ex: StringBuilder)
        // Immutable -> La schimbare de valoare trebuie sa atribuim rezultatul la o variabila pentru ca se schimba adresa de memorie ( ex: String)

        // String -> cand nu avem multe modificari
        // StringBuilder -> cand modificam des, de ex in bucle

        // List<String> -> fori, foreach, while, Stream

        // Stream -> Potok, Flux de date,

        // Sursa -> Operatie Terminala (colectare in colectie)

        // Sursa -> Operatie Intermediara (filter) -> Operatie Intermediara (map) -> Operatie Terminala
//
//        List<String> list = new ArrayList<>();
//        list.add("A");
//        list.add("B");
//        list.add("C");
//
//       list = list.stream() // am deschis un flux pe sursa (Lista)
//               .filter(new PreidicatImplementare()) // BC
//               .map(new FunctionImpl()) // bc
//               .collect(Collectors.toList()); //  Operatie Terminala(Am colectat in alta lista)  doar adresa de memorie a fost schimbata
//
//        System.out.println(list);
//
//
//        List<String> list2 = new ArrayList<>();
//        list2.add("A");
//        list2.add("C");
//        list2.add("C");
//        list2.add("B");
//        list2.add("B");
//
//      Optional<String> optional =  list2.stream() // am deschis un flux pe sursa (Lista)
//                 .peek(t -> System.out.println("Inainte de filter: " + t))
//                .filter(t -> t.equals("B") || t.equals("C"))
//                 .peek(t -> System.out.println("Inainte de map: " + t))
//                .map(t -> t.toLowerCase()) // bc
////                 .peek(t -> System.out.println("Inainte de distinct: " + t))
//                .distinct()
////                 .peek(t -> System.out.println("Inainte de colectare: " + t))
//                 .limit(10)
//                 .skip(0)
////                 .sorted((String a, String b) -> {
////                     if (a.equals("a")) {
////                         return -1;
////                     } else {
////                         return 1;
////                     }
////                 })
////                .filter(t -> t.equals("c"))
//              .findFirst(); //  Operatie Terminala(Am colectat in alta lista)  doar adresa de memorie a fost schimbata
//
//        System.out.println(optional.get());

//        System.out.println(list2);

        // Sursa, Operatie Intermediara, Operatie Terminala

        // filter -> peek


        // Operatii intermediare -> filter, map, distinct, limit, skip, sorted
        // Operatii terminale -> collect, forEach, count


        StreamService streamService = new StreamService();

        List<Person> list = new ArrayList<>();
        list.add(new Person("Ion Rusu", 24));
        list.add(new Person("Ion Popescu", 22));
        list.add(new Person("Andrei Lungu", 24));
        list.add(new Person("Andrei Cipu", 24));
        list.add(new Person("Vasile Tonofa", 25));

//       List<Person> personList = streamService.filterByNameWithStream(list, "Rusu");

//        List<Person> personList = streamService.filterByAgeWithStream(list, 23);
//        list = streamService.celebrateBirthDay(list, "Lungu");
//        long count = streamService.countByAge(list, 25);

//        Person person = streamService.findPersonByNameFirst(list, "Fiodor");
//
//        if(person != null) {
//            System.out.println(person.getAge());
//        }

        Optional<Person> person = streamService.findPersonByNameOptional(list, "Vasile");

        person.ifPresent(value -> System.out.println(value.getAge()));

    }
}