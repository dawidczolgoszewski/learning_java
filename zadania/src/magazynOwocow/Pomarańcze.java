package magazynOwocow;

public class Pomarańcze extends Owoce {
    private String [] kontynent = {"afryka", "ameryka", "azja"};
    private String wybranyKontynent;

    public void wyswietlKontynenty() {
        System.out.println("Kontynenty, z którego są pomarańcze:");
        for (int i=0; i<kontynent.length; i++)
        {
            System.out.println(i+1 + " - " + kontynent[i]);
        }
        System.out.println();
    }

    public void wybierzKontynent(int x){
        switch (x){
            case 1:
                wybranyKontynent = kontynent[0];
                System.out.println(String.format("Wybrałeś kontynent: %s",wybranyKontynent));
                break;
            case 2:
                wybranyKontynent = kontynent[1];
                System.out.println(String.format("Wybrałeś kontynent: %s",wybranyKontynent));
                break;
            case 3:
                wybranyKontynent = kontynent[2];
                System.out.println(String.format("Wybrałeś kontynent: %s",wybranyKontynent));
                break;
        }
    }

    @Override
    public String toString() {
        return "pomarańcz - " + "kontynent: "+ wybranyKontynent + " || cena: " + getCena() + "zł"+ " || waga: " + getWaga() + "kg";
    }
}
