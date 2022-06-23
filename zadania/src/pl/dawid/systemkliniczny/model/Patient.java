package pl.dawid.systemkliniczny.model;

import java.time.LocalDate;

public class Patient extends Person {
    private LocalDate dateOfAdmission;

    public Patient(String name, String surname, int age, long pesel, Branch branch, LocalDate dateOfAdmission) {
        super(name, surname, age, pesel, branch, Occupation.PACJENT);
        this.dateOfAdmission = dateOfAdmission;
    }

    public Patient() {
        super();
    }

    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(LocalDate dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    @Override
    public String toString() {
        return "Imie - " + getName() + ", Nazwisko - " + getSurname() + ", Wiek - " +
                getAge() + " lat" + ", Pesel - " + getPesel() + ", Data przyjecia: " + getDateOfAdmission();

    }
}
