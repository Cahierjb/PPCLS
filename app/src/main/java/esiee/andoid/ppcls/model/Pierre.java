package esiee.andoid.ppcls.model;

import java.net.URI;
import java.util.Arrays;

import esiee.andoid.ppcls.R;

public class Pierre extends Coup {

    //Constructor
    public Pierre() {
        super("Pierre");
        faiblesses = Arrays.asList("Feuille","Spock");
        setImage(R.drawable.rock);
    }

}
