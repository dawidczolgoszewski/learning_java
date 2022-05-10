package pl.dawid.zad4interfejsy;

public interface StringBoxReverser{

    default String suprise (String suprise) {
        String pomocnicza = "";
        if (suprise.length() > 10) {
            return suprise.toUpperCase();
        } else {
            for (int i=suprise.length()-1; i>=0; i--) {
                pomocnicza += suprise.charAt(i);
            }
            suprise = pomocnicza;
            return suprise;
        }
    }
}
