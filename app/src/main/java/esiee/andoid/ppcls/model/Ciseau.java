package esiee.andoid.ppcls.model;

import java.util.Arrays;

import esiee.andoid.ppcls.R;

public class Ciseau extends Coup {

    //Constructor
    public Ciseau() {
        super("Ciseau");
        faiblesses = Arrays.asList("Pierre","Spock");
        setImage(R.drawable.scissors);
    }

}
