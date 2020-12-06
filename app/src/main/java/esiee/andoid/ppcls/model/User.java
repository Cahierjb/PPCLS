package esiee.andoid.ppcls.model;

import java.io.Serializable;

public class User implements Serializable {

    //Attributs
    private String firstName;
    private String lastName;
    private char gender;
    private int age;
    private String mail;
    private String username;
    private String score;

    //Constructeurs
    public User(String firstName, String lastName, char gender, int age, String username,String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.mail = mail;
        this.username = username;
        this.score = "0";
    }

    public User(String firstName, String lastName, char gender, int age, String mail, String username, String score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.mail = mail;
        this.username = username;
        this.score = score;
    }

    public User(String username, String score) {
        this.username = username;
        this.score = score;
    }


    //Getter and Setter

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getMail() {
        return mail;
    }

    public String getUsername() {
        return username;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

}
