package magazynowocow;

public class Apple extends Fruit{
    private String [] typy = {"ligol", "grosnol", "champion"};
    private String wybranyTyp;

    public void displayType() {
        System.out.println("Typy jabłek:");
        int x=1;
        for(String i:typy){
            System.out.println(x + " - " + i);
            x++;
        }
        System.out.println();
    }

    public void choiceType(int x){
        switch (x){
            case 1:
                wybranyTyp = typy[0];
                System.out.println("Wybrałeś typ: " + wybranyTyp);
                break;
            case 2:
                wybranyTyp = typy[1];
                System.out.println("Wybrałeś typ: " + wybranyTyp);
                break;
            case 3:
                wybranyTyp = typy[2];
                System.out.println("Wybrałeś typ: " + wybranyTyp);
                break;
            default:
                System.out.println("Podaj odpowiednią cyfrę przypisaną do kontynentu");
                break;
        }
    }

    @Override
    public String toString() {
        return "jabłko - " + "typ: "+ wybranyTyp + " || cena: " + getCena() + "zł" + " || waga: " + getWaga() + "kg";
    }
}
