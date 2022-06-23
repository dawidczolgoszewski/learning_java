package pl.dawid.systemkliniczny.model;

public class Employee extends Person {
    private int practice;

    public Employee(String name, String surname, int age, long pesel, Branch branch, Occupation occupation, int practice) {
        super(name, surname, age, pesel, branch, occupation);
        this.practice = practice;
    }

    public Employee() {
        super();
    }

    public int getPractice() {
        return practice;
    }

    public void setPractice(int practice) {
        this.practice = practice;
    }

    @Override
    public String toString() {
        return "Imie - " + getName() + ", Nazwisko - " + getSurname() + ", Pesel - " + getPesel() + ", Staz - " +
                getPractice() + " lat";
    }
}
