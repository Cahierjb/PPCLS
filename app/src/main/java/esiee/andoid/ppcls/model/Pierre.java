package devandroid.ppcls.model;

import java.util.Arrays;

public class Pierre extends Coup {

    //Constructor
    public Pierre() {
        super("Pierre");
        faiblesses = Arrays.asList("Facebook", "Paypal", "Google", "Yahoo");
    }

}
