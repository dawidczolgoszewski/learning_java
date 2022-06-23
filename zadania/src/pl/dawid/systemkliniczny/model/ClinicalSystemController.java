package pl.dawid.systemkliniczny.model;

import pl.dawid.systemkliniczny.db.HospitalDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class ClinicalSystemController{

    private HospitalDatabase hospitalDatabase;
    private boolean startSystem = true;
    private Scanner scanner = new Scanner(System.in);

    private void hospitalStart(){
        System.out.println("PROGRAM - System kliniczny");
        System.out.print("Podaj nazwę szpitala: ");
        String name = scanner.next();
        System.out.print("Podaj ulicę, na której znajduje się szpital: ");
        String streetName = scanner.next();
        System.out.print("Podaj maksymalną ilośc osób, którą szpital pomieści: ");
        int maxSize = scanner.nextInt();
        Hospital hospital = new Hospital(name,streetName, maxSize);
        HospitalDatabase hospitalDatabase = new HospitalDatabase(hospital);
        this.hospitalDatabase = hospitalDatabase;
    }

    private void displayMenu(){
        System.out.println("MENU");
        System.out.println("1 - Dodanie pacjenta");
        System.out.println("2 - Przywrócenie wypisanego pacjenta");
        System.out.println("3 - Dodanie/Usunięcie pracownika");
        System.out.println("4 - Zebranie informacji o oddziale");
        System.out.println("5 - Wypis pacjenta");
        System.out.println("6 - Sortuj informacje");
        System.out.println("7 - Export danych do csv");
        System.out.println("8 - Wyjdź z programu");
        System.out.print("Podaj numer: ");
    }

    private void addPatient(){
        if (hospitalDatabase.hospitalSize()){
            System.out.println("Osiągnięto maksymalną ilość osób, którą szpital pomieści!");
        }else{
            System.out.print("Podaj imie: ");
            String name = scanner.next();
            System.out.print("Podaj nazwisko: ");
            String surname = scanner.next();
            System.out.print("Podaj wiek: ");
            int age = scanner.nextInt();
            System.out.print("Podaj pesel: ");
            long pesel = scanner.nextLong();
            String strPesel = Long.toString(pesel);
            while (strPesel.length() != 11){
                System.out.println("Wprowadź poprawny pesel!");
                System.out.print("Podaj pesel: ");
                pesel = scanner.nextLong();
                strPesel = Long.toString(pesel);
            }
            if (hospitalDatabase.checkPatient(pesel) || hospitalDatabase.checkEmployee(pesel)) {
                System.out.println("Podana osoba o takim peselu jest już w systemie!");
            } else if (hospitalDatabase.checkPatientBranch(pesel)) {
                System.out.println("Podana osoba o takim peselu została wypisana! Jeśli chcesz przywrócić tę osobę musisz wybrać z Menu opcję numer - 2");
            } else {
                System.out.print("Data przyjęcia pacjenta to: " + LocalDate.now());
                LocalDate dateOfAdmission = LocalDate.now();
                System.out.println();
                System.out.println("Dostępne oddziały: ");
                hospitalDatabase.availableBranches();
                System.out.print("Podaj przypisaną cyfrę do oddziału: ");
                int branch = scanner.nextInt();
                String branchName = "";
                for (int i = 0; i < Branch.values().length; i++) {
                    if (branch == 1) {
                        branchName = Branch.KARDIOLOGIA.name();
                    }
                    if (branch == 2) {
                        branchName = Branch.KARDIOCHIRURGIA.name();
                    }
                    if (branch == 3) {
                        branchName = Branch.LARYNGOLOGIA.name();
                    }
                }
                hospitalDatabase.addPatient(new Patient(name, surname, age, pesel, Branch.valueOf(branchName), dateOfAdmission));
            }
        }
    }

    private void restorePatient(){
        try {
            if (hospitalDatabase.hospitalSize()) {
                System.out.println("Osiągnięto maksymalną ilość osób, którą szpital pomieści!");
            }else{
                if (hospitalDatabase.checkDischargePatient()) {
                    System.out.println("Wszyscy wypisani pacjenci:");
                    hospitalDatabase.displayDischargePatient();
                    System.out.print("Podaj numer pacjenta: ");
                    int id = scanner.nextInt();
                    System.out.println("Dostępne oddziały: ");
                    hospitalDatabase.availableBranches();
                    System.out.print("Podaj przypisaną cyfrę do oddziału, do którego pacjent ma być przypisany: ");
                    int branch = scanner.nextInt();
                    String branchName = "";
                    for (int i = 0; i < Branch.values().length; i++) {
                        if (branch == 1) {
                            branchName = Branch.KARDIOLOGIA.name();
                        }
                        if (branch == 2) {
                            branchName = Branch.KARDIOCHIRURGIA.name();
                        }
                        if (branch == 3) {
                            branchName = Branch.LARYNGOLOGIA.name();
                        }
                    }
                    hospitalDatabase.restore(id, Branch.valueOf(branchName));
                } else {
                    System.out.println("Brak wypisanych pacjentów!");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Podaj poprawny numer pacjenta!");
        } catch (IllegalArgumentException ex) {
            System.out.println("Podaj poprawny numer oddziału!");
        }
    }
    private void addDoctor(){
        if (hospitalDatabase.hospitalSize()) {
            System.out.println("Osiągnięto maksymalną ilość osób, którą szpital pomieści!");
        }else {
            System.out.print("Podaj imie: ");
            String name = scanner.next();
            System.out.print("Podaj nazwisko: ");
            String surname = scanner.next();
            System.out.print("Podaj wiek: ");
            int age = scanner.nextInt();
            System.out.print("Podaj pesel: ");
            Long pesel = scanner.nextLong();
            String strPesel = Long.toString(pesel);
            while (strPesel.length() != 11) {
                System.out.println("Wprowadź poprawny pesel!");
                System.out.print("Podaj pesel: ");
                pesel = scanner.nextLong();
                strPesel = Long.toString(pesel);
            }
            if (hospitalDatabase.checkEmployee(pesel) || hospitalDatabase.checkPatient(pesel)) {
                System.out.println("Podana osoba ma już taki pesel w systemie! Upewnij się, że dobrze wpisujesz dane.");
            } else if (hospitalDatabase.checkPatientBranch(pesel)) {
                System.out.println("Podana osoba o takim peselu została wypisana! Podaj poprawny pesel.");
            } else {
                System.out.print("Podaj staż pracy: ");
                int practice = scanner.nextInt();
                System.out.println("Dostępne oddziały: ");
                hospitalDatabase.availableBranches();
                System.out.print("Podaj przypisaną cyfrę do oddziału: ");
                int branch = scanner.nextInt();
                String branchName = "";
                for (int i = 0; i < pl.dawid.systemklinicznyold.Branch.values().length; i++) {
                    if (branch == 1) {
                        branchName = pl.dawid.systemklinicznyold.Branch.KARDIOLOGIA.name();
                    }
                    if (branch == 2) {
                        branchName = pl.dawid.systemklinicznyold.Branch.KARDIOCHIRURGIA.name();
                    }
                    if (branch == 3) {
                        branchName = pl.dawid.systemklinicznyold.Branch.LARYNGOLOGIA.name();
                    }
                }
                hospitalDatabase.addEmployee(new Employee(name, surname, age, pesel, Branch.valueOf(branchName), Occupation.DOKTOR, practice));
            }
        }
    }

    private void addNurse(){
        if (hospitalDatabase.hospitalSize()) {
            System.out.println("Osiągnięto maksymalną ilość osób, którą szpital pomieści!");
        }else {
            System.out.print("Podaj imie: ");
            String name = scanner.next();
            System.out.print("Podaj nazwisko: ");
            String surname = scanner.next();
            System.out.print("Podaj wiek: ");
            int age = scanner.nextInt();
            System.out.print("Podaj pesel: ");
            long pesel = scanner.nextLong();
            String strPesel = Long.toString(pesel);
            while (strPesel.length() != 11) {
                System.out.println("Wprowadź poprawny pesel!");
                System.out.print("Podaj pesel: ");
                pesel = scanner.nextLong();
                strPesel = Long.toString(pesel);
            }
            if (hospitalDatabase.checkEmployee(pesel) || hospitalDatabase.checkPatient(pesel)) {
                System.out.println("Podana osoba ma już taki pesel w systemie! Upewnij się, że dobrze wpisujesz dane.");
            } else if (hospitalDatabase.checkPatientBranch(pesel)) {
                System.out.println("Podana osoba o takim peselu została wypisana! Podaj poprawny pesel.");
            } else {
                System.out.print("Podaj staż pracy: ");
                int practice = scanner.nextInt();
                System.out.println("Dostępne oddziały: ");
                hospitalDatabase.availableBranches();
                System.out.print("Podaj przypisaną cyfrę do oddziału: ");
                int branch = scanner.nextInt();
                String branchName = "";
                for (int i = 0; i < pl.dawid.systemklinicznyold.Branch.values().length; i++) {
                    if (branch == 1) {
                        branchName = pl.dawid.systemklinicznyold.Branch.KARDIOLOGIA.name();
                    }
                    if (branch == 2) {
                        branchName = pl.dawid.systemklinicznyold.Branch.KARDIOCHIRURGIA.name();
                    }
                    if (branch == 3) {
                        branchName = pl.dawid.systemklinicznyold.Branch.LARYNGOLOGIA.name();
                    }
                }
                hospitalDatabase.addEmployee(new Employee(name, surname, age, pesel, Branch.valueOf(branchName), Occupation.PIELEGNIARKA, practice));
            }
        }
    }

    private void deleteEmployee(){
        System.out.print("Podaj pesel pracownika: ");
        long pesel = scanner.nextLong();
        hospitalDatabase.deleteEmployee(pesel);
    }
    private void addEmployeeOrDelete(){
        boolean employee = true;
        while (employee) {
            System.out.println("1 - Dodaj lekarza");
            System.out.println("2 - Dodaj pielęgniarke");
            System.out.println("3 - Usuń pracownika");
            System.out.println("4 - Wyjdź do Menu");
            int employee2 = scanner.nextInt();
            switch (employee2) {
                case 1:
                   addDoctor();
                    break;
                case 2:
                   addNurse();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    employee = false;
                    break;
            }
        }
    }

    private void collectInformationAboutHospitalWard(){
        boolean branchMenu = true;
        while (branchMenu) {
            System.out.println("1 - Wyszukaj oddział");
            System.out.println("2 - Pełny szpital");
            System.out.print("Podaj numer: ");
            int branch2 = scanner.nextInt();
            switch (branch2) {
                case 2:
                    System.out.println("Dostępne oddziały: ");
                    hospitalDatabase.availableBranches();
                    System.out.print("Wpisz liczbę od 1 do 3 to przekieruje Ciebie do opcji numer 1: ");
                    int branchInt = scanner.nextInt();
                    if (branchInt >= 1 && branchInt <= 3) {
                    } else {
                        System.out.println("Złą wpisałeś liczbę!");
                        break;
                    }
                case 1:
                    try {
                        System.out.print("Prosze podać nazwę oddziału: ");
                        String branch = scanner.next();
                        hospitalDatabase.searchBranch(Branch.valueOf(branch));
                        branchMenu = false;
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Podaj poprawną nazwę oddziału (Pamiętaj o dużych literach)!");
                    }

            }
        }
    }

    private void dischargePatient(){
        System.out.print("Podaj pesel pacjenta: ");
        long pesel3 = scanner.nextLong();
        hospitalDatabase.dischargePatient(pesel3);
    }

    private void sortInformation(){
        hospitalDatabase.sortPatients();
        hospitalDatabase.sortEmployees();
        System.out.println("Dane zostały posortowane!");
    }

    private void exportPatient() throws FileNotFoundException{
        if (hospitalDatabase.checkDataIsEmptyPatients()){
            System.out.println("W systemie nie ma żadnego pacjenta! Plik nie zostanie utworzony.");
        }else{
            System.out.print("Podaj nazwę pliku: ");
            String fileName = scanner.next();
            File csvFile = new File(fileName + ".csv");
            PrintWriter out = new PrintWriter(csvFile);
            hospitalDatabase.csvPatients(out);
        }
    }

    private void exportDoctor() throws FileNotFoundException{
        if (hospitalDatabase.checkDataIsEmptyDoctor()){
            System.out.println("W systemie nie ma żadnego doktora! Plik nie zostanie utworzony.");
        }else{
            System.out.print("Podaj nazwę pliku: ");
            String fileName = scanner.next();
            File csvFile = new File(fileName + ".csv");
            PrintWriter out = new PrintWriter(csvFile);
            hospitalDatabase.csvDoctor(out);
        }
    }

    private void exportNurse() throws FileNotFoundException{
        if (hospitalDatabase.checkDataIsEmptyNurse()){
            System.out.println("W systemie nie ma żadnej pielęgniarki! Plik nie zostanie utworzony.");
        }else{
            System.out.print("Podaj nazwę pliku: ");
            String fileName = scanner.next();
            File csvFile = new File(fileName + ".csv");
            PrintWriter out = new PrintWriter(csvFile);
            hospitalDatabase.csvNurse(out);
        }
    }

    private void exportCSV() throws FileNotFoundException{
        boolean export = true;
        while (export){
            System.out.println("1 - Wyeksportuj dane wszystkich pacjentów");
            System.out.println("2 - Wyeksportuj dane wszystkich lekarzy");
            System.out.println("3 - Wyeksportuj dane wszystkich pielęgniarek");
            System.out.println("4 - Wyjdź do MENU");
            System.out.print("Podaj numer: ");
            int export2 = scanner.nextInt();
            switch (export2){
                case 1:
                   exportPatient();
                    break;
                case 2:
                    exportDoctor();
                    break;
                case 3:
                   exportNurse();
                    break;
                case 4:
                    export = false;
                    break;
            }
        }
    }

    private void endProgram(){
        startSystem = false;
    }

    private void startProgram() throws FileNotFoundException{
        hospitalStart();
        while (startSystem) {
            displayMenu();
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    restorePatient();
                    break;
                case 3:
                    addEmployeeOrDelete();
                    break;
                case 4:
                    collectInformationAboutHospitalWard();
                    break;
                case 5:
                    dischargePatient();
                    break;
                case 6:
                    sortInformation();
                    break;
                case 7:
                    exportCSV();
                    break;
                case 8:
                    endProgram();
                    break;
            }
        }
    }

    public void start() throws FileNotFoundException{
        startProgram();
    }
}
