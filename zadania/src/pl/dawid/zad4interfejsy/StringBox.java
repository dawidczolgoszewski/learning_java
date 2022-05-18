package pl.dawid.zad4interfejsy;

public class StringBox implements StringBoxReverser{
    private String suprise;

    public void setSuprise(String suprise) {
        this.suprise = suprise;
    }

    public String getSuprise() {
        return suprise;
    }

    @Override
    public String suprise(String suprise) {
        this.suprise = StringBoxReverser.super.suprise(suprise);
        return StringBoxReverser.super.suprise(suprise);
    }

}
