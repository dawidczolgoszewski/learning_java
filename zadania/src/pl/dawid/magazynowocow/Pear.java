package magazynowocow;

public class Pear extends Fruit{
    private String [] cecha = {"wiosna", "lato", "jesien", "zima"};
    private String wybranaCecha;

    public void displayCharacter() {
        System.out.println("Cechy okresu zbioru:");
        int x=1;
        for(String i:cecha){
            System.out.println(x + " - " + i);
            x++;
        }
        System.out.println();
    }

    public void choiceCharacter(int x){
        switch (x){
            case 1:
                wybranaCecha = cecha[0];
                System.out.println("Wybrałeś ceche: " + wybranaCecha);
                break;
            case 2:
                wybranaCecha = cecha[1];
                System.out.println("Wybrałeś ceche: " + wybranaCecha);
                break;
            case 3:
                wybranaCecha = cecha[2];
                System.out.println("Wybrałeś ceche: " + wybranaCecha);
                break;
            case 4:
                wybranaCecha = cecha[3];
                System.out.println("Wybrałeś ceche: " + wybranaCecha);
                break;
            default:
                System.out.println("Podaj odpowiednią cyfrę przypisaną do kontynentu");
                break;
        }
    }

    @Override
    public String toString() {
        return "gruszka - " + "cecha: "+ wybranaCecha + " || cena: " + getCena() + "zł" + " || waga: " + getWaga() + "kg";
    }
}
