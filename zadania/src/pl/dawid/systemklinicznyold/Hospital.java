package pl.dawid.systemkliniczny;

import java.util.Comparator;

public class Hospital implements Comparator<Hospital> {
    private String name;
    private String surname;
    private int age;
    private long pesel;
    private Branch branch;
    private Occupation occupation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    @Override
    public int compare(Hospital o1, Hospital o2) {
        int result = o1.getName().compareTo(o2.getName());
            if (result == 0){
                result = o1.getSurname().compareTo(o2.getSurname());
                    if (result == 0){
                        return o1.getAge() - o2.getAge();
                    }
                    return result;
                }
                return result;
            }

}


