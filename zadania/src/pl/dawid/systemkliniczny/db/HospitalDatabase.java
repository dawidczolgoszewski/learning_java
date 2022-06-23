package pl.dawid.systemkliniczny.db;

import pl.dawid.systemkliniczny.model.*;

import java.io.PrintWriter;
import java.util.Collections;

public class HospitalDatabase {
    private Hospital hospital;

    public HospitalDatabase(Hospital hospital) {
        this.hospital = hospital;
    }

    public boolean hospitalSize(){
        if (this.hospital.getPatients().size() + this.hospital.getEmployees().size() == hospital.getMaxSize()){
            return true;
        }
        return false;
    }

    public void addPatient(Patient patient){
        this.hospital.getPatients().add(patient);
        System.out.println("Udało Ci się dodać nową osobę!");
    }

    public void addEmployee(Employee employee){
        this.hospital.getEmployees().add(employee);
        System.out.println("Udało Ci się dodać nową osobę!");
    }

    public int sumPatient(Branch branch){
        int sum = 0;
        for (int i=0; i< this.hospital.getPatients().size(); i++){
            if (this.hospital.getPatients().get(i).getBranch().equals(branch)){
                sum++;
            }
        }
        return sum;
    }

    public int sumDoctor(Branch branch){
        int sum = 0;
        for (int i=0; i< this.hospital.getEmployees().size(); i++){
            if (this.hospital.getEmployees().get(i).getBranch().equals(branch) && this.hospital.getEmployees().get(i).getOccupation().equals(Occupation.DOKTOR)){
                sum++;
            }
        }
        return sum;
    }

    public int sumNurse(Branch branch){
        int sum = 0;
        for (int i=0; i< this.hospital.getEmployees().size(); i++){
            if (this.hospital.getEmployees().get(i).getBranch().equals(branch) && this.hospital.getEmployees().get(i).getOccupation().equals(Occupation.PIELEGNIARKA)){
                sum++;
            }
        }
        return sum;
    }


    public void searchBranch(Branch branch){ //zostaje
        System.out.println("Ilość pacjentów na " + branch + ": " + sumPatient(branch));
        for(Patient x : this.hospital.getPatients()){
            if (x.getBranch().equals(branch)){
                System.out.println(x);
            }
        }
        System.out.println("Ilość lekarzy na " + branch + ": " + sumDoctor(branch));
        for(Employee x : this.hospital.getEmployees()){
            if (x.getBranch().equals(branch) && x.getOccupation().equals(Occupation.DOKTOR)){
                System.out.println(x);
            }
        }
        System.out.println("Ilość pielęgniarek na " + branch + ": " + sumNurse(branch));
        for(Employee x : this.hospital.getEmployees()){
            if (x.getBranch().equals(branch) && x.getOccupation().equals(Occupation.PIELEGNIARKA)){
                System.out.println(x);
            }
        }
    }

    public void dischargePatient(long pesel){ //zostaje
        for (Patient x : this.hospital.getPatients()){
            if (x.getPesel() == pesel){
                x.setBranch(Branch.NIEOBECNY);
                System.out.println("Pacjent został wypisany!");
            }else{
                System.out.println("Podaj poprawny pesel!");
            }
        }
        if (this.hospital.getPatients().isEmpty()){
            System.out.println("Nie ma wpisanych pacjentów w systemie!");
        }
    }

    public void displayDischargePatient(){ //to musi zostac
        for (int i=0; i< this.hospital.getPatients().size(); i++){
            if (this.hospital.getPatients().get(i).getBranch().equals(Branch.NIEOBECNY)){
                System.out.println("Nr - " + (i+1) + " - " + this.hospital.getPatients().get(i));
            }
        }

    }

    public boolean checkDischargePatient(){ //to musi zostac
        for (int i=0; i< this.hospital.getPatients().size(); i++){
            if (this.hospital.getPatients().get(i).getBranch().equals(Branch.NIEOBECNY)){
                return true;
            }
        }
        return false;
    }

    public boolean checkPatient(long pesel){ //to musi zostac
        for (Patient x : this.hospital.getPatients()){
            if (x.getPesel() == pesel && !x.getBranch().equals(Branch.NIEOBECNY)){
                return true;
            }
        }
        return false;
    }

    public boolean checkEmployee (long pesel){
        for (Employee x : this.hospital.getEmployees()){
            if (x.getPesel() == pesel){
                return true;
            }
        }
        return false;
    }

    public boolean checkPatientBranch(long pesel){ //to musi zostac
        for (Patient x : this.hospital.getPatients()){
            if (x.getPesel() == pesel && x.getBranch().equals(Branch.NIEOBECNY)){
                return true;
            }
        }
        return false;
    }


    public void restore(int id, Branch branch){ //zostaje
        if (this.hospital.getPatients().get(id-1).getBranch().equals(Branch.NIEOBECNY)){
            this.hospital.getPatients().get(id-1).setBranch(branch);
            System.out.println("Pacjent został przywrócony!");
        }else{
            System.out.println("Podana osoba o takim numerze " + id + "nie jest wypisana!");
        }
    }

    public void availableBranches(){ //zostaje
        int x = 1;
        for (Branch branch : Branch.values()){
            if (branch.equals(Branch.NIEOBECNY)){
                break;
            }else{
                System.out.println(x + " - " + branch);
            }
            x++;
        }
    }

    public void deleteEmployee(long pesel){ //zostaje
        for (int i=0; i< this.hospital.getEmployees().size(); i++){
            if (this.hospital.getEmployees().get(i).getPesel() == pesel){
                System.out.println("Udało Ci się usunąć pracownika: " + this.hospital.getEmployees().get(i));
                this.hospital.getEmployees().remove(i);
            }else {
                System.out.println("Podaj poprawny pesel!");
            }
        }
        if (this.hospital.getEmployees().isEmpty()){
            System.out.println("Brak pracowników w systemie!");
        }

    }

    public boolean checkDataIsEmptyDoctor(){
        for(Employee x: this.hospital.getEmployees()){
            if (x.getOccupation().equals(Occupation.DOKTOR)){
                return false;
            }
        }
        return true;
    }

    public boolean checkDataIsEmptyNurse(){
        for(Employee x: this.hospital.getEmployees()){
            if (x.getOccupation().equals(Occupation.PIELEGNIARKA)){
                return false;
            }
        }
        return true;
    }

    public boolean checkDataIsEmptyPatients(){
        if (this.hospital.getPatients().isEmpty()){
            return true;
        }
        return false;
    }

    public void sortPatients(){
        Collections.sort(this.hospital.getPatients(), new Patient());
    }

    public void sortEmployees(){
        Collections.sort(this.hospital.getEmployees(), new Employee());
    }

    public void csvPatients(PrintWriter out){
        for (Patient x: this.hospital.getPatients()){
            out.printf("%s, %s, %s\n", x, x.getOccupation(), x.getBranch());
        }
        out.close();
        System.out.println("Utworzono pomyślnie plik!");
    }

    public void csvDoctor(PrintWriter out){
        for (Employee x: this.hospital.getEmployees()){
            if(x.getOccupation().equals(Occupation.DOKTOR)){
                out.printf("%s, %s, %s\n", x, x.getOccupation(), x.getBranch());
            }
        }
        out.close();
        System.out.println("Utworzono pomyślnie plik!");
    }

    public void csvNurse(PrintWriter out){
        for (Employee x: this.hospital.getEmployees()){
            if(x.getOccupation().equals(Occupation.PIELEGNIARKA)){
                out.printf("%s, %s, %s\n", x, x.getOccupation(), x.getBranch());
            }
        }
        out.close();
        System.out.println("Utworzono pomyślnie plik!");
    }

}
