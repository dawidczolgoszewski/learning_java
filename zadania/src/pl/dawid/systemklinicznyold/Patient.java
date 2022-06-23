package pl.dawid.systemkliniczny;

import java.util.Date;

public class Patient extends Hospital {
    private String dateOfAdmission;

    public Patient(String name, String surname, int age, long pesel, String dateOfAdmission, Branch branch) {
        setName(name);
        setSurname(surname);
        setBranch(branch);
        setAge(age);
        setPesel(pesel);
        this.dateOfAdmission = dateOfAdmission;
        setOccupation(Occupation.PACJENT);
    }

    public String getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(String dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    @Override
    public String toString() {
        return "Imie - " + getName() + ", Nazwisko - " + getSurname() + ", Wiek - " +
                getAge() + " lat" + ", Pesel - " + getPesel() + ", Data przyjęcia: " + getDateOfAdmission();

    }
}
