package pl.dawid.zad3interfejsy.ComparableContainer;

import pl.dawid.zad3interfejsy.ComparatorContainer.PersonComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        list.add(new Person("Basia"));
        list.add(new Person("Tola"));
        list.add(new Person("Olek"));
        list.add(new Person("Karol"));
        list.add(new Person("Wiola"));

        Collections.sort(list);

        System.out.println(list); //Comparable

        Collections.sort(list, new PersonComparator());

        System.out.println(list); //Comparator

        Collections.sort(list, new PersonComparator().reversed());

        System.out.println(list); //Comparator.odwrócony

        List<Person2> list2 = new ArrayList<>();
        list2.add(new Person2("Basia"));
        list2.add(new Person2("Tola"));
        list2.add(new Person2("Olek"));
        list2.add(new Person2("Karol"));
        list2.add(new Person2("Wiola"));

        Collections.sort(list2);

        System.out.println(list2); //Comparable.odwrócony



    }
}
