package magazynowocow;

public class ChoiceFruit {
    private static final String ORANGE = "Pomarańcz";
    private static final String APPLE = "Jabłko";
    private static final String PEAR = "Gruszka";
    private static final String OPTIONCHOOSER = "Wybierz jaki chcesz dodać owoc do magazynu:";

    public static final void SETOPTIONCHOOSER(){
        System.out.println(OPTIONCHOOSER);
        System.out.println("1 - " + ORANGE);
        System.out.println("2 - " + APPLE);
        System.out.println("3 - " + PEAR);
    }
}
