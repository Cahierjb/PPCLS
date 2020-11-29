package devandroid.ppcls.model;

import java.util.List;

public abstract class Coup implements Comparable<Coup> {

    //Attributs
    private String nom;
    private String image;
    protected List<String> faiblesses;

    //Constructeur
    public Coup(String nom) {
        this.nom = nom;
    }

    //Accesseurs
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<String> getFaiblesses() {
        return faiblesses;
    }

    public void setFaiblesses(List<String> faiblesses) {
        this.faiblesses = faiblesses;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        String result = "Nom du coup : "+ nom + '\n' + "Faiblesses : ";
        for (String coup : faiblesses)
            result += coup;
        return  result;
    }

    //Methode Comparabale
    @Override
    public int compareTo(Coup adverse) {
        int result = 0;// Result vaut 0 victoire sur l'adverse sinon defaite
        for (String coup : faiblesses){
            if (coup == adverse.getNom()) {
                result = 1;
            }
        }
        return result;
    }
}
