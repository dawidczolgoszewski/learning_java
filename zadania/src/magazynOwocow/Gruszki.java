package magazynOwocow;

public class Gruszki extends Owoce{
    private String [] cecha = {"wiosna", "lato", "jesien", "zima"};
    private String wybranaCecha;

    public void wyswietlCechy() {
        System.out.println("Cechy okresu zbioru:");
        for (int i=0; i<cecha.length; i++)
        {
           System.out.println(i+1 + " - " + cecha[i]);
        }
        System.out.println();
    }

    public void wybierzCechy(int x){
        switch (x){
            case 1:
                wybranaCecha = cecha[0];
                System.out.println(String.format("Wybrałeś ceche: %s",wybranaCecha));
                break;
            case 2:
                wybranaCecha = cecha[1];
                System.out.println(String.format("Wybrałeś ceche: %s",wybranaCecha));
                break;
            case 3:
                wybranaCecha = cecha[2];
                System.out.println(String.format("Wybrałeś ceche: %s",wybranaCecha));
                break;
            case 4:
                wybranaCecha = cecha[3];
                System.out.println(String.format("Wybrałeś ceche: %s",wybranaCecha));
                break;
        }
    }

    @Override
    public String toString() {
        return "gruszka - " + "cecha: "+ wybranaCecha + " || cena: " + getCena() + "zł" + " || waga: " + getWaga() + "kg";
    }
}
