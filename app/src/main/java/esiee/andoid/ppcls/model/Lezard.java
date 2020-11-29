package esiee.andoid.ppcls.model;

import java.util.Arrays;

import esiee.andoid.ppcls.R;

public class Lezard extends Coup{
    //Constructor
    public Lezard() {
        super("Lezard");
        faiblesses = Arrays.asList("Pierre","Ciseau");
        setImage(R.drawable.lizard);
    }
}
