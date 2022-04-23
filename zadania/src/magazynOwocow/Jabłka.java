package magazynOwocow;

public class Jabłka extends Owoce{
    private String [] typy = {"ligol", "grosnol", "champion"};
    private String wybranyTyp;

    public void wyswietlTypy() {
        System.out.println("Typy jabłek:");
        for (int i=0; i<typy.length; i++)
        {
            System.out.println(i+1 + " - " + typy[i]);
        }
        System.out.println();
    }

    public void wybierzTyp(int x){
        switch (x){
            case 1:
                wybranyTyp = typy[0];
                System.out.println(String.format("Wybrałeś typ: %s",wybranyTyp));
                break;
            case 2:
                wybranyTyp = typy[1];
                System.out.println(String.format("Wybrałeś typ: %s",wybranyTyp));
                break;
            case 3:
                wybranyTyp = typy[2];
                System.out.println(String.format("Wybrałeś typ: %s",wybranyTyp));
                break;
        }
    }

    @Override
    public String toString() {
        return "jabłko - " + "typ: "+ wybranyTyp + " || cena: " + getCena() + "zł" + " || waga: " + getWaga() + "kg";
    }
}
