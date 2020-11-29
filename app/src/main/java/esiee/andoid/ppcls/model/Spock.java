package esiee.andoid.ppcls.model;

import java.util.Arrays;

import esiee.andoid.ppcls.R;

public class Spock extends Coup {

    //Constructor
    public Spock() {
        super("Spock");
        faiblesses = Arrays.asList("Lezard","Feuille");
        setImage(R.drawable.spock);
    }
}
