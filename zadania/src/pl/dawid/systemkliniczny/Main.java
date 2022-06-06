package pl.dawid.systemkliniczny;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("System kliniczny");
        Database database = new Database();
        Scanner scanner = new Scanner(System.in);
        boolean startSystem = true;
        while (startSystem) {
            System.out.println("MENU");
            System.out.println("1 - Dodanie pacjenta");
            System.out.println("2 - Przywrócenie wypisanego pacjenta");
            System.out.println("3 - Dodanie/Usunięcie pracownika");
            System.out.println("4 - Zebranie informacji o oddziale");
            System.out.println("5 - Wypis pacjenta");
            System.out.println("6 - Sortuj informacje");
            System.out.println("7 - Export danych do csv");
            System.out.println("8 - Wyjdź z programu");
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
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
                        if (database.checkPatient(pesel)) {
                            System.out.println("Podana osoba o takim peselu jest już w systemie! Pacjent może zostać przypisany tylko i wyłącznie do jednego oddziału!");
                        } else if (database.checkPatientBranch(pesel)) {
                            System.out.println("Podana osoba o takim peselu została wypisana! Jeśli chcesz przywrócić tę osobę musisz wybrać z Menu opcję numer - 2");
                        } else {
                            System.out.print("Podaj date przyjęcia (format daty: rrrr-mm-dd): "); //2022-05-12
                            String dateOfAdmission = scanner.next();
                            System.out.println("Dostępne oddziały: ");
                            database.availableBranches();
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
                            database.addPerson(new Patient(name, surname, age, pesel, dateOfAdmission, Branch.valueOf(branchName)));
                        }
                    break;
                case 2:
                    try {
                        if (database.checkDischargePatient()) {
                            System.out.println("Wszyscy wypisani pacjenci:");
                            database.displayDischargePatient();
                            System.out.print("Podaj numer pacjenta: ");
                            int id = scanner.nextInt();
                            System.out.println("Dostępne oddziały: ");
                            database.availableBranches();
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
                            database.restore(id, Branch.valueOf(branchName));
                        } else {
                            System.out.println("Brak wypisanych pacjentów!");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Podaj poprawny numer pacjenta!");
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Podaj poprawny numer oddziału!");
                    }


                    break;
                case 3:
                    boolean employee = true;
                    while (employee) {
                        System.out.println("1 - Dodaj lekarza");
                        System.out.println("2 - Dodaj pielęgniarke");
                        System.out.println("3 - Usuń pracownika");
                        System.out.println("4 - Wyjdź do Menu");
                        int employee2 = scanner.nextInt();
                        switch (employee2) {
                            case 1:
                                System.out.print("Podaj imie: ");
                                name = scanner.next();
                                System.out.print("Podaj nazwisko: ");
                                surname = scanner.next();
                                System.out.print("Podaj wiek: ");
                                age = scanner.nextInt();
                                System.out.print("Podaj pesel: ");
                                pesel = scanner.nextLong();
                                strPesel = Long.toString(pesel);
                                while (strPesel.length() != 11){
                                    System.out.println("Wprowadź poprawny pesel!");
                                    System.out.print("Podaj pesel: ");
                                    pesel = scanner.nextLong();
                                    strPesel = Long.toString(pesel);
                                }
                                if (database.checkEmployee(pesel)) {
                                    System.out.println("Podana osoba ma już taki pesel w systemie! Upewnij się, że dobrze wpisujesz dane.");
                                } else {
                                    System.out.print("Podaj staż pracy: ");
                                    int practice = scanner.nextInt();
                                    System.out.println("Dostępne oddziały: ");
                                    database.availableBranches();
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
                                    database.addPerson(new Employee(name, surname, age, pesel, practice, Occupation.DOKTOR, Branch.valueOf(branchName)));
                                }
                                break;
                            case 2:
                                System.out.print("Podaj imie: ");
                                name = scanner.next();
                                System.out.print("Podaj nazwisko: ");
                                surname = scanner.next();
                                System.out.print("Podaj wiek: ");
                                age = scanner.nextInt();
                                System.out.print("Podaj pesel: ");
                                pesel = scanner.nextLong();
                                strPesel = Long.toString(pesel);
                                while (strPesel.length() != 11){
                                    System.out.println("Wprowadź poprawny pesel!");
                                    System.out.print("Podaj pesel: ");
                                    pesel = scanner.nextLong();
                                    strPesel = Long.toString(pesel);
                                }
                                if (database.checkEmployee(pesel)) {
                                    System.out.println("Podana osoba ma już taki pesel w systemie! Upewnij się, że dobrze wpisujesz dane.");
                                } else {
                                    System.out.print("Podaj staż pracy: ");
                                    int practice = scanner.nextInt();
                                    System.out.println("Dostępne oddziały: ");
                                    database.availableBranches();
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
                                    database.addPerson(new Employee(name, surname, age, pesel, practice, Occupation.PIELĘGNIARKA, Branch.valueOf(branchName)));
                                }
                                break;
                            case 3:
                                System.out.print("Podaj pesel pracownika: ");
                                pesel = scanner.nextInt();
                                database.deleteEmployee(pesel);
                                break;
                            case 4:
                                employee = false;
                                break;
                        }
                    }
                    break;
                case 4:
                    boolean branchMenu = true;
                    while (branchMenu) {
                        System.out.println("1 - Wyszukaj oddział");
                        System.out.println("2 - Pełny szpital");
                        int branch2 = scanner.nextInt();
                        switch (branch2) {
                            case 2:
                                System.out.println("Dostępne oddziały: ");
                                database.availableBranches();
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
                                    database.searchBranch(Branch.valueOf(branch));
                                    branchMenu = false;
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Podaj poprawną nazwę oddziału (Pamiętaj o dużych literach)!");
                                }

                        }
                    }
                    break;
                case 5:
                    System.out.print("Podaj pesel pacjenta: ");
                    long pesel3 = scanner.nextLong();
                    database.dischargePatient(pesel3);
                    break;
                case 6:
                    database.sort();
                    break;
                case 7:
                    if (database.checkDataIsEmpty()){
                        System.out.println("W systemie nie ma wprowadzonej żadnej osoby! Plik nie zostanie utworzony.");
                    }else{
                        System.out.print("Podaj nazwę pliku: ");
                        String fileName = scanner.next();
                        File csvFile = new File(fileName + ".csv");
                        PrintWriter out = new PrintWriter(csvFile);
                        database.csv(out);
                    }
                    break;
                case 8:
                    startSystem = false;
                    break;
            }
        }
    }
}

