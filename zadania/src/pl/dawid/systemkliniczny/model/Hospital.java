package pl.dawid.systemkliniczny.model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String name;
    private String streetName;
    private int maxSize;
    private List<Patient> patients = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    public Hospital(String name, String streetName, int maxSize) {
        this.name = name;
        this.streetName = streetName;
        this.maxSize = maxSize;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public int getMaxSize() {
        return maxSize;
    }
}
