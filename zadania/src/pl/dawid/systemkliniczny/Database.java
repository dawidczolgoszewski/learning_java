package pl.dawid.systemkliniczny;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Database {
    private List<Hospital> data = new ArrayList<>();

    public void addPerson(Hospital person){
        data.add(person);
        System.out.println("Udało Ci się dodać nową osobę!");
    }

    public int sumPatient(Branch branch){
        int sum = 0;
        for (int i=0; i< data.size(); i++){
            if (data.get(i).getBranch().equals(branch) && data.get(i).getOccupation().equals(Occupation.PACJENT)){
               sum++;
            }
        }
        return sum;
    }

   public int sumDoctor(Branch branch){
        int sum = 0;
        for (int i=0; i< data.size(); i++){
            if (data.get(i).getBranch().equals(branch) && data.get(i).getOccupation().equals(Occupation.DOKTOR)){
                sum++;
            }
        }
        return sum;
    }

    public int sumNurse(Branch branch){
        int sum = 0;
        for (int i=0; i< data.size(); i++){
            if (data.get(i).getBranch().equals(branch) && data.get(i).getOccupation().equals(Occupation.PIELĘGNIARKA)){
                sum++;
            }
        }
        return sum;
    }


    public void searchBranch(Branch branch){
        System.out.println("Ilość pacjentów na " + branch + ": " + sumPatient(branch));
        for(Hospital x: data){
            if (x.getBranch().equals(branch) && x.getOccupation().equals(Occupation.PACJENT)){
                System.out.println(x);
            }
        }
        System.out.println("Ilość lekarzy na " + branch + ": " + sumDoctor(branch));
        for(Hospital x: data){
            if (x.getBranch().equals(branch) && x.getOccupation().equals(Occupation.DOKTOR)){
                System.out.println(x);
            }
        }
        System.out.println("Ilość pielęgniarek na " + branch + ": " + sumNurse(branch));
        for(Hospital x: data){
            if (x.getBranch().equals(branch) && x.getOccupation().equals(Occupation.PIELĘGNIARKA)){
                System.out.println(x);
            }
        }
    }

    public void dischargePatient(long pesel){
       for (Hospital x: data){
            if (x.getPesel() == pesel && x.getOccupation().equals(Occupation.PACJENT) ){
                x.setBranch(Branch.NIEOBECNY);
                System.out.println("Pacjent został wypisany!");
            }else if (x.getPesel() == pesel && !x.getOccupation().equals(Occupation.PACJENT)){
                System.out.println("Podana osoba nie jest pacjentem!");
            }else{
                System.out.println("Podaj poprawny pesel!");
            }
        }
       if (data.isEmpty()){
           System.out.println("Nie ma wpisanych pacjentów w systemie!");
       }
    }

    public void displayDischargePatient(){
        for (int i=0; i< data.size(); i++){
            if (data.get(i).getBranch().equals(Branch.NIEOBECNY)){
                System.out.println("Nr - " + (i+1) + " - " + data.get(i));
            }
        }

    }

    public boolean checkDischargePatient(){
        for (int i=0; i< data.size(); i++){
            if (data.get(i).getBranch().equals(Branch.NIEOBECNY)){
                return true;
            }
        }
        return false;
    }

    public boolean checkPatient(long pesel){
        for (Hospital x : data){
            if (x.getPesel() == pesel && !x.getBranch().equals(Branch.NIEOBECNY)){
                return true;
            }
        }
        return false;
    }

    public boolean checkEmployee (long pesel){
        for (Hospital x : data){
            if (x.getPesel() == pesel){
                return true;
            }
        }
        return false;
    }

    public boolean checkPatientBranch(long pesel){
        for (Hospital x : data){
            if (x.getPesel() == pesel && x.getBranch().equals(Branch.NIEOBECNY)){
                return true;
            }
        }
        return false;
    }


    public void restore(int id, Branch branch){
            if (data.get(id-1).getBranch().equals(Branch.NIEOBECNY)){
                data.get(id-1).setBranch(branch);
                System.out.println("Pacjent został przywrócony!");
            }else{
                System.out.println("Podana osoba o takim numerze " + id + "nie jest wypisana!");
            }
    }

    public void sort(){
        Collections.sort(data, new Hospital());
        System.out.println("Dane zostały posortowane!");
    }

    public void availableBranches(){
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

    public void deleteEmployee(long pesel){
        for (int i=0; i< data.size(); i++){
            if (data.get(i).getPesel() == pesel && (data.get(i).getOccupation()==Occupation.DOKTOR || data.get(i).getOccupation()==Occupation.PIELĘGNIARKA)){
                System.out.println("Udało Ci się usunąć pracownika: " + data.get(i));
                data.remove(i);
            }else {
                System.out.println("Podaj poprawny pesel!");
            }
        }
        if (data.isEmpty()){
            System.out.println("Brak osób w systemie!");
        }

    }

    public boolean checkDataIsEmpty(){
        if (data.isEmpty()){
            return true;
        }
        return false;
    }

    public void csv(PrintWriter out){
        for (Hospital x: data){
            out.printf("%s, %s, %s\n", x, x.getOccupation(), x.getBranch());
        }
        out.close();
        System.out.println("Utworzono pomyślnie plik!");
    }


}
