package esiee.andoid.ppcls.model;

import java.util.Arrays;

import esiee.andoid.ppcls.R;

public class Feuille extends Coup{

    //Constructor
    public Feuille() {
        super("Feuille");
        faiblesses = Arrays.asList("Ciseau","Lezard");
        setImage(R.drawable.copy);
    }
}
