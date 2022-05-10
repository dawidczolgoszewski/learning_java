package pl.dawid.zad3interfejsy.ComparatorContainer;

import pl.dawid.zad3interfejsy.ComparableContainer.Person;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int x = o1.getName().compareTo(o2.getName());
        return x;
    }
}
