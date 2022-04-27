package magazynowocow;

import java.util.ArrayList;

public class Magazine{

    private int koniec=0;
    private double waga=0;
    private ArrayList<Fruit> magazyn = new ArrayList<>();

    public void addToMagazine(Fruit owoce){
        if (magazyn.size()==10){
            System.out.println("Magazyn osiągnął maksymalną ilość owoców!");
        }
        else{
            System.out.println("Dodałeś do magazynu:");
            magazyn.add(owoce);
            for (int i = magazyn.size(); i<=magazyn.size(); i++){
                waga += magazyn.get(magazyn.size()-1).getWaga();
            }
            System.out.println("Pozostało miejsca w magazynie: " + pozostaloMiejsca() + "kg");
        }

    }

    public void displayMagazine(){
        if (magazyn.size()==0){
            System.out.println("Nie ma żadnych owoców w magazynie");
        }
        else{
            for (int i=0; i<magazyn.size(); i++) {
                System.out.println(i+1 + " - " + magazyn.get(i));
            }
        }

    }

    public void buyFromMagazine(int x){
            System.out.println("Kupiłeś: " + magazyn.get(x-1));
            waga -= magazyn.get(x-1).getWaga();
            magazyn.remove(x-1);
    }

    public double pozostaloMiejsca(){
        return 5-waga;
    }

    public void End(){
        if (magazyn.size() == 0 ){
            System.out.println("Brak towaru!");
            koniec++;
        }
    }

    public int getKoniec() {
        return koniec;
    }

    public double getWaga() {
        return waga;
    }
}
