package pl.dawid.systemkliniczny;

public class Employee extends Hospital {
    private int practice;

    public Employee(String name, String surname, int age, long pesel, int practice, Occupation occupation, Branch branch) {
        setName(name);
        setSurname(surname);
        setBranch(branch);
        setAge(age);
        setPesel(pesel);
        this.practice = practice;
        setOccupation(occupation);
    }

    public int getPractice() {
        return practice;
    }

    public void setPractice(int practice) {
        this.practice = practice;
    }

    @Override
    public String toString() {
        return "Imie - " + getName() + ", Nazwisko - " + getSurname() + ", Pesel - " + getPesel() + ", Staż - " +
                getPractice() + " lat";
    }
}
