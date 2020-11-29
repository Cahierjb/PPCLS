package devandroid.ppcls.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import devandroid.ppcls.model.*;

public class IA {

    //Attributs
    private Map<Coup, Double> listCoup = new HashMap<Coup, Double>()
    {
        {
            put(new Pierre(), 0.2);
            put(new Feuille(), 0.2);
            put(new Ciseau(), 0.2);
            put(new Lezard(), 0.2);
            put(new Spock(), 0.2);
        }
    };
    private int difficulte; //entre 1 et 5

    //Constructeur
    public IA(int difficulte){
        if (difficulte > 1 && difficulte < 5){
            this.difficulte = difficulte;
        }
    }


    //L'IA joue un coup
    public Coup Joue(Coup adverse){

        //Recuperation des faiblesse de l'adversaire
        List<String> advFaiblesses = adverse.getFaiblesses();
        //Modification des coeffs
        for (Coup i : listCoup.keySet()) {
            if (advFaiblesses.contains(i.getNom())) {
                if (listCoup.containsKey(i))
                    listCoup.put(i, listCoup.get(i) * difficulte);
            }
        }
        //Coefficient de la faiblesse multiplié par la difficulté
        //Generation d'un coup aleatoire dans la liste
        double rand = Math.random();
        double sommeProba = 0;
        for(double i : listCoup.values())
            sommeProba += i;
        double ratio = 1.0f / sommeProba;
        double tempDist = 0;
        for (Coup i : listCoup.keySet()) {
            tempDist += listCoup.get(i);
            if (rand / ratio <= tempDist) {
                return i;
            }
        }
        return null;

    }

}
