package pl.dawid.zad3interfejsy.ComparableContainer;

public class Person implements Comparable<Person>{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        int x = this.name.compareTo(o.name);
        return x;
    }

    @Override
    public String toString() {
        return name;
    }
}
