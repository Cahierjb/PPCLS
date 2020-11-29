package devandroid.ppcls.model;

public class User {

    //Attributs
    private String firstName;
    private String lastName;
    private char gender;
    private int age;
    private String mail;
    private String username;

    //Constructeurs
    public User(String firstName, String lastName, char gender, int age, String username,String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.mail = mail;
        this.username = username;
    }

    public User(String account) {
        if (account.contains("@"))
            this.mail = account;
        else this.username = account;
    }


    //Getter and Setter

    //Mehtodes


}
