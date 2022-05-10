package magazynowocow;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean skonczPetle = true;
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        ChoiceFruit choiceFruit = new ChoiceFruit();
        Magazine magazyn = new Magazine();
        System.out.println();
        System.out.println("Magazyn owoców");
        while (skonczPetle) {
            System.out.println();
            System.out.println("Wybierz opcje:");
            System.out.println("1 - Dodaj owoc do magazynu");
            System.out.println("2 - Wyświetl magazyn");
            System.out.println("3 - Kup coś z magazynu");
            System.out.println("4 - Wyjdź z magazynu");
            switch (scanner.nextInt()) {
                case 1:
                    choiceFruit.SETOPTIONCHOOSER();
                    switch (scanner.nextInt()) {
                        case 1:
                            Orange pomarańcze = new Orange();
                            boolean skonczDrugaPetle = true;
                            while (skonczDrugaPetle) {
                                System.out.println("1 - Wyświetl kontynent, z którego są pomarańcze");
                                System.out.println("2 - Wybierz kontynent");
                                System.out.println("3 - Podaj wartość owocu");
                                System.out.println("4 - Podaj wage owocu");
                                System.out.println("5 - Dodaj owoc do magazynu");
                                switch (scanner.nextInt()) {
                                    case 1:
                                        pomarańcze.displayContinent();
                                        break;
                                    case 2:
                                        System.out.print("Wpisz cyfrę odpowiedniego kontynentu: ");
                                        pomarańcze.choiceContinent(scanner.nextInt());
                                        break;
                                    case 3:
                                        System.out.print("Podaj wartość: ");
                                        pomarańcze.setCena(scanner.nextDouble());
                                        System.out.println("Wartość owocu to: " + pomarańcze.getCena() + "zł");
                                        break;
                                    case 4:
                                        System.out.print("Podaj wagę: ");
                                        double waga = scanner.nextDouble();
                                        if (magazyn.getWaga() + waga >= 5){
                                            System.out.println("Magazyn osiągnął maksymalną wagę! Zmniejsz wage owocu");
                                        }
                                        else{
                                            pomarańcze.setWaga(waga);
                                            System.out.println("Waga owocu to: " + waga + "kg");
                                        }
                                        break;
                                    case 5:
                                        magazyn.addToMagazine(pomarańcze);
                                        skonczDrugaPetle = false;
                                        break;
                                    default:
                                        System.out.println("Wybierz poprawną opcję");
                                        break;
                                }
                            }
                            break;


                        case 2:
                            Apple jabłka = new Apple();
                            boolean skonczTrzeciaPetle = true;
                            while (skonczTrzeciaPetle) {
                                System.out.println("1 - Wyświetl typy jabłek");
                                System.out.println("2 - Wybierz typ");
                                System.out.println("3 - Podaj wartość owocu");
                                System.out.println("4 - Podaj wage owocu");
                                System.out.println("5 - Dodaj owoc do magazynu");
                                switch (scanner.nextInt()) {
                                    case 1:
                                        jabłka.displayType();
                                        break;
                                    case 2:
                                        System.out.print("Wpisz cyfrę odpowiedniego typu: ");
                                        jabłka.choiceType(scanner.nextInt());
                                        break;
                                    case 3:
                                        System.out.print("Podaj wartość: ");
                                        jabłka.setCena(scanner.nextDouble());
                                        System.out.println("Wartość owocu to: " + jabłka.getCena() + "zł");
                                        break;
                                    case 4:
                                        System.out.print("Podaj wagę: ");
                                        double waga = scanner.nextDouble();
                                        if (magazyn.getWaga() + waga >= 5){
                                            System.out.println("Magazyn osiągnął maksymalną wagę! Zmniejsz wage owocu");
                                        }
                                        else{
                                            jabłka.setWaga(waga);
                                            System.out.println("Waga owocu to: " + waga + "kg");
                                        }
                                        break;
                                    case 5:
                                        magazyn.addToMagazine(jabłka);
                                        skonczTrzeciaPetle = false;
                                        break;
                                    default:
                                        System.out.println("Wybierz poprawną opcję");
                                        break;
                                }

                            }
                            break;

                        case 3:
                            Pear gruszki = new Pear();
                            boolean skonczCzwartaPetle = true;
                            while (skonczCzwartaPetle) {
                                System.out.println("1 - Wyświetl cechy okresu zbioru gruszek");
                                    System.out.println("2 - Wybierz ceche");
                                    System.out.println("3 - Podaj wartość owocu");
                                    System.out.println("4 - Podaj wage owocu");
                                System.out.println("5 - Dodaj owoc do magazynu");
                                switch (scanner.nextInt()) {
                                    case 1:
                                        gruszki.displayCharacter();
                                        break;
                                    case 2:
                                        System.out.print("Wpisz cyfrę odpowiedniej cechy: ");
                                        gruszki.choiceCharacter(scanner.nextInt());
                                        break;
                                    case 3:
                                        System.out.print("Podaj wartość: ");
                                        gruszki.setCena(scanner.nextDouble());
                                        System.out.println("Wartość owocu to: " + gruszki.getCena() + "zł");
                                        break;
                                    case 4:
                                        System.out.print("Podaj wagę: ");
                                        double waga = scanner.nextDouble();
                                        if (magazyn.getWaga() + waga >= 5){
                                            System.out.println("Magazyn osiągnął maksymalną wagę! Zmniejsz wage owocu");
                                        }
                                        else{
                                            gruszki.setWaga(waga);
                                            System.out.println("Waga owocu to: " + waga + "kg");
                                        }
                                        break;
                                    case 5:
                                        magazyn.addToMagazine(gruszki);
                                        skonczCzwartaPetle = false;
                                        break;
                                    default:
                                        System.out.println("Wybierz poprawną opcję");
                                        break;
                                }

                            }
                            break;

                    }
                case 2:
                    magazyn.displayMagazine();
                    break;
                case 3:
                    try {
                        magazyn.End();
                        if (magazyn.getKoniec() == 1) {
                            skonczPetle = false;
                        }
                        else{
                            magazyn.displayMagazine();
                            System.out.print("Wybierz pozycje, która Ciebie interesuje: ");
                            magazyn.buyFromMagazine(scanner.nextInt());
                        }
                    }
                    catch(IndexOutOfBoundsException e){
                        System.out.println("Na tej pozycji nic nie ma do kupienia");
                    }
                    break;
                case 4:
                    System.out.println("Wyszedłeś z magazynu");
                    skonczPetle = false;
                    break;
            }


        }
    }
}
