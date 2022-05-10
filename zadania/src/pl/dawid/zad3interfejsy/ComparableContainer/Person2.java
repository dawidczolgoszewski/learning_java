package pl.dawid.zad3interfejsy.ComparableContainer;

public class Person2 implements Comparable<Person2>{
    private String name;

    public Person2(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person2 o) {
        int x = this.name.compareTo(o.name);
        return -1 * x;
    }

    @Override
    public String toString() {
        return name;
    }
}
