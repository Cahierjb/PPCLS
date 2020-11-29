package devandroid.ppcls.model;

import java.util.Arrays;

public class Feuille extends Coup{

    //Constructor
    public Feuille() {
        super("Feuille");
        faiblesses = Arrays.asList("Facebook", "Paypal", "Google", "Yahoo");
    }
}
