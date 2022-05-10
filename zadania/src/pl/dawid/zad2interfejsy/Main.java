package pl.dawid.zad2interfejsy;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        String [] tablica = {"hau hau", "miau miau"};
        if (dog.makeSound() == tablica[0]){
            System.out.println("jestem psem hau hau");
        }
        if (cat.makeSound() == tablica[1]){
            System.out.println("jestem kotem miau miau");
        }
    }
}
