package magazynowocow;

public class Orange extends Fruit {
    private String [] kontynent = {"afryka", "ameryka", "azja"};
    private String wybranyKontynent;

    public void displayContinent() {
        System.out.println("Kontynenty, z którego są pomarańcze:");
        int x=1;
        for(String i:kontynent){
            System.out.println(x + " - " + i);
            x++;
        }
        System.out.println();
    }

    public void choiceContinent(int x){
        switch (x){
            case 1:
                wybranyKontynent = kontynent[0];
                System.out.println("Wybrałeś kontynent: "+ wybranyKontynent);
                break;
            case 2:
                wybranyKontynent = kontynent[1];
                System.out.println("Wybrałeś kontynent: "+ wybranyKontynent);
                break;
            case 3:
                wybranyKontynent = kontynent[2];
                System.out.println("Wybrałeś kontynent: "+ wybranyKontynent);
                break;
            default:
                System.out.println("Podaj odpowiednią cyfrę przypisaną do kontynentu");
                break;
        }
    }

    @Override
    public String toString() {
        return "pomarańcz - " + "kontynent: "+ wybranyKontynent + " || cena: " + getCena() + "zł"+ " || waga: " + getWaga() + "kg";
    }
}
